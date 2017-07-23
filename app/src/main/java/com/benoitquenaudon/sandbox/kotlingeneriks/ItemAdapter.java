package com.benoitquenaudon.sandbox.kotlingeneriks;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.benoitquenaudon.sandbox.kotlingeneriks.databinding.RowHeaderBinding;
import com.benoitquenaudon.sandbox.kotlingeneriks.databinding.RowLoadingBinding;
import java.util.Collections;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
  private List<ItemDisplayable> items = Collections.emptyList();

  @Override public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);

    switch (viewType) {
      case R.layout.row_header:
        return new ItemViewHolder.HeaderViewHolder((RowHeaderBinding) binding);
      case R.layout.row_loading:
        return new ItemViewHolder.LoadingRowViewHolder((RowLoadingBinding) binding);
      default:
        throw new UnsupportedOperationException(
            "don't know how to deal with this viewType: " + viewType);
    }
  }

  @SuppressWarnings("unchecked") @Override
  public void onBindViewHolder(ItemViewHolder holder, int position) {
    holder.bind(items.get(position));
  }

  @Override public void onViewRecycled(ItemViewHolder holder) {
    super.onViewRecycled(holder);
    holder.unbind();
  }

  @Override public int getItemCount() {
    return items.size();
  }

  @Override public int getItemViewType(int position) {
    ItemDisplayable item = items.get(position);
    if (item instanceof RowDisplayable) {
      return R.layout.row_header;
    }
    if (item instanceof LoadingRowDisplayable) {
      return R.layout.row_loading;
    }
    throw new UnsupportedOperationException("Don't know how to deal with this item: " + item);
  }
}
