package net.zpavelocity.im.common.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewBindingAdapter<T, VDB extends ViewDataBinding>
        extends RecyclerView.Adapter<BaseRecyclerViewBindingAdapter.BindingViewHolder<VDB>> {

    private static final String TAG = BaseRecyclerViewBindingAdapter.class.getSimpleName();

    protected List<T> list = new ArrayList<>();

    private OnItemClickListener<T> onItemClickListener;
    private OnItemLongClickListener<T> onItemLongClickListener;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
    
    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener<T> onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    @NonNull
    @Override
    public BindingViewHolder<VDB> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        VDB mBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), getItemLayoutResId(), parent, false);
        return new BindingViewHolder<VDB>(mBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder<VDB> holder, int position) {
        final T t = list.get(position);
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(v, position, t);
            }
        });
        holder.itemView.setOnLongClickListener(v -> {
            if (onItemLongClickListener != null) {
                onItemLongClickListener.onItemLoneClick(v, position, t);
            }
            return true;
        });

        convert(position, holder.getBinding(), t);
    }

    protected abstract void convert(int position, VDB binding, T t);

    // item布局id
    protected abstract int getItemLayoutResId();

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class BindingViewHolder<VHB extends ViewDataBinding> extends RecyclerView.ViewHolder {

        private VHB binding;

        public BindingViewHolder(VHB binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public VHB getBinding() {
            return binding;
        }
    }

    public interface OnItemClickListener<T> {
        void onItemClick(View v, int position, T t);
    }

    public interface OnItemLongClickListener<T> {
        void onItemLoneClick(View v, int position, T t);
    }
}
