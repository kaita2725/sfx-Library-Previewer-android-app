package id.ac.umn.uts_35715;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<Integer> sfx = new ArrayList<>();
    private ArrayList<String> sfxname = new ArrayList<>();
    private ArrayList<String> desc = new ArrayList<>();
    private Context context;

    public Adapter(Context context, ArrayList<Integer> sfx, ArrayList<String> sfxname, ArrayList<String> desc)
    {
        this.context = context;
        this.sfx = sfx;
        this.sfxname = sfxname;
        this.desc = desc;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_library, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.text1.setText(sfxname.get(position));
        holder.text2.setText(desc.get(position));

        holder.constraintLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(context, mediaPlayer.class);
                intent.putExtra("name", sfxname.get(position));
                intent.putExtra("desc", desc.get(position));
                intent.putExtra("sfx", sfx.get(position));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return sfxname.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ConstraintLayout constraintLayout;
        TextView text1;
        TextView text2;
        ImageButton delete;

        public ViewHolder(View view)
        {
            super(view);
            text1 = (TextView) view.findViewById(R.id.sfxTitle);
            text2 = (TextView) view.findViewById(R.id.detail);

            constraintLayout = view.findViewById(R.id.contraintLayout);

            delete = view.findViewById(R.id.permaDelete);
            delete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            sfxname.remove(position);
            desc.remove(position);
            notifyItemRemoved(position);
        }
    }

}
