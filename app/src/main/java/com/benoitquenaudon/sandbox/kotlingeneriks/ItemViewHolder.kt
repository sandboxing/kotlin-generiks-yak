package com.benoitquenaudon.sandbox.kotlingeneriks

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.benoitquenaudon.sandbox.kotlingeneriks.databinding.RowHeaderBinding
import com.benoitquenaudon.sandbox.kotlingeneriks.databinding.RowLoadingBinding


sealed class ItemViewHolder<out B : ViewDataBinding, in T : ItemDisplayable>(
    val binding: B
) : RecyclerView.ViewHolder(binding.root) {

  abstract fun bind(item: T)
  abstract fun unbind()

  class HeaderViewHolder(
      binding: RowHeaderBinding
  ) : ItemViewHolder<RowHeaderBinding, RowDisplayable>(binding) {

    override fun bind(item: RowDisplayable) {
      // do stuff
      binding.executePendingBindings()
    }

    override fun unbind() {
      // do stuff
      binding.executePendingBindings()
    }
  }

  class LoadingRowViewHolder(
      binding: RowLoadingBinding
  ) : ItemViewHolder<RowLoadingBinding, LoadingRowDisplayable>(binding) {

    override fun bind(item: LoadingRowDisplayable) {
      // nothing to do
    }

    override fun unbind() {
      // nothing to do
    }
  }
}