package timeline.timeline;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.repsly.library.timelineview.LineType;
import com.repsly.library.timelineview.TimelineView;

import java.util.List;

/**
 * Created by Administrator on 26/4/2560.
 */

class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ViewHolder>{
    private final int orientation;
    private final List<ListItem> items;

    TimelineAdapter(int orientation, List<ListItem> items) {
        this.orientation = orientation;
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.item_vertical;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_posh_start_end.setText(items.get(position).get_posh_start_end());
        holder.tv_posh_place_name.setText(items.get(position).get_posh_place_name());
        // holder.timelineView.setLineType(getLineType(position));
        // holder.timelineView.setNumber(position);

        // Make first and last markers stroked, others filled
        //if (position == 0 || position + 1 == getItemCount()) {
        //    holder.timelineView.setFillMarker(false);
        //} else {
        //    holder.timelineView.setFillMarker(true);
        //}

        //if (position == 4) {
        //    holder.timelineView.setDrawable(AppCompatResources
        //            .getDrawable(holder.timelineView.getContext(),
        //                    R.drawable.ic_checked));
        //} else {
        //    holder.timelineView.setDrawable(null);
        //}

        // Set every third item active
        // holder.timelineView.setActive(position % 3 == 2);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private LineType getLineType(int position) {
        if (getItemCount() == 1) {
            return LineType.ONLYONE;

        } else {
            if (position == 0) {
                return LineType.BEGIN;

            } else if (position == getItemCount() - 1) {
                return LineType.END;

            } else {
                return LineType.NORMAL;
            }
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TimelineView timelineView;
        TextView tv_posh_start_end;
        TextView tv_posh_place_name;

        ViewHolder(View view) {
            super(view);
            timelineView = (TimelineView) view.findViewById(R.id.timeline);
            tv_posh_start_end = (TextView) view.findViewById(R.id.tv_posh_start_end);
            tv_posh_place_name = (TextView) view.findViewById(R.id.tv_posh_place_name);
        }
    }
}
