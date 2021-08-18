package com.example.wingstask.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wingstask.Product
import com.example.wingstask.R
import com.example.wingstask.databinding.ListProductBinding

class AdapterProduct : RecyclerView.Adapter<AdapterProduct.CardViewHolder>() {

    private var listData = ArrayList<Product>()
    var onItemClick: ((Product) -> Unit)? = null

    fun setData(newData: List<Product>?) {
        if (newData == null) return
        listData.clear()
        listData.addAll(newData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder =
        CardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_product, parent, false)
        )

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size


    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListProductBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun bind(data: Product) {

            with(binding) {
                tvNameProduct.text = data.productName
                tvPriceProduct.text = "Rp. ${data.price},-"
                if (data.discount != 0) {
                    tvDiscountProduct.text = "hehe"
                }
            }

        }

    }

}