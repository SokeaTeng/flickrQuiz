package rupp.kalim.fe.flickrquiz

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.ThemedSpinnerAdapter
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import rupp.kalim.fe.flickrquiz.Model.Photo
import rupp.kalim.fe.flickrquiz.adapter.PhotoAdapter
import rupp.kalim.fe.flickrquiz.helper.flickrAPI

class MainActivity : AppCompatActivity() {
    private lateinit var mQueue: RequestQueue
    private lateinit var jsonObjectRequest: JsonObjectRequest
    private var photoList = ArrayList<String>()
    private var url = flickrAPI.apiLink

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mQueue = Volley.newRequestQueue(this)
        jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener { response ->
                    val photos = response.getJSONObject("photos")
                    val perpage = photos.getInt("perpage")
                    val photoArray = photos.getJSONArray("photo")

                    for (i in 0 until perpage-1) {
                        val photo = photoArray.getJSONObject(i)

                        val id = photo.getString("id")
                        val farm = photo.getInt("farm")
                        val server = photo.getInt("server")
                        val secret = photo.getString("secret")

                        val mPhoto = Photo(id, farm, server, secret)
                        photoList.add(mPhoto.url)

                        Log.d("image",photoList.get(i))
                    }
                },
                Response.ErrorListener {
                    Log.d("image","stop")

                }
                )
        mQueue.add(jsonObjectRequest)

        viewManager = GridLayoutManager(this, 2)
        viewAdapter = PhotoAdapter(photoList, this)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }


    }
}
