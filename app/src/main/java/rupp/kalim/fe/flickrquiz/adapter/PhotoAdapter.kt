package rupp.kalim.fe.flickrquiz.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item.view.*
import rupp.kalim.fe.flickrquiz.R
import rupp.kalim.fe.flickrquiz.R.id.image

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    private val mData: ArrayList<String>
    private var mContext: Context

    constructor(mData: ArrayList<String>, mContext: Context){
        this.mData = mData
        this.mContext = mContext
    }

    class ViewHolder : RecyclerView.ViewHolder{
        val imageView: ImageView
        constructor(view: View) : super(view) {
            this.imageView = view.image
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(mContext)
                .load(mData[position])
                .thumbnail(0.1f)
                .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

}