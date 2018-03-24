package ro.hackitall.foodwaste.home.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import ro.hackitall.foodwaste.R
import ro.hackitall.foodwaste.home.mvp.models.ProductModel

/**
 * Created by Emilian on 3/24/2018.
 *
 */

class ProductAdapter(val context: Context, val products: Array<ProductModel>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.product_item, parent, false)
        val viewHolder = ProductViewHolder(view)
        return  viewHolder
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder?, position: Int) {
        holder?.productName?.text = products[position].name
        holder?.productShop?.text = products[position].store.username
        holder?.productPrice?.text = products[position].price + " RON";
        Picasso.with(context).load(products[position].picture).into(holder?.productImage)
    }

    class ProductViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        val productName = itemView?.findViewById<TextView>(R.id.productName)
        val productShop = itemView?.findViewById<TextView>(R.id.productShop)
        val productPrice = itemView?.findViewById<TextView>(R.id.productPrice)
        val productImage = itemView?.findViewById<ImageView>(R.id.productImage)

    }
}