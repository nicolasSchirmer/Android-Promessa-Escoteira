package gejapao.promessa.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import gejapao.promessa.R;

public class CustomAdapter  extends ArrayAdapter<itemRow> {

    Context context;

    public CustomAdapter(Context context, int resourceId,
            List<itemRow> items) {
        super(context, resourceId, items);
        this.context = context;
    }

    // private view holder class
    private class ViewHolder {
        ImageView bg;
        ImageView logoBg;
        TextView txtTitle;
      //  RelativeLayout rootLay;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        itemRow item = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.etapa, null);

            holder = new ViewHolder();
           // holder.rootLay = (RelativeLayout) convertView.findViewById(R.id.rootEtapa);
            holder.bg = (ImageView) convertView.findViewById(R.id.bg);
            holder.logoBg = (ImageView) convertView.findViewById(R.id.logoBg);
            holder.txtTitle = (TextView) convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtTitle.setText(item.getTitle());

        holder.bg.setImageResource(item.getBg());
        //holder.bg.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        holder.logoBg.setImageResource(item.getLogobg());

        return convertView;
    }
}


