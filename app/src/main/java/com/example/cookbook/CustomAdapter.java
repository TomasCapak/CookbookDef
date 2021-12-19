package com.example.cookbook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList idRecept, nazevrec, popis, postupVareni, dobaVareniVMinutach;

    Animation translate_anim;


    CustomAdapter(Activity activity,
                  Context context,
                  ArrayList idRecept,
                  ArrayList nazevrec,
                  ArrayList popis,
                  ArrayList postupVareni,
                  ArrayList dobaVareniVMinutach) {
        this.activity = activity;
    this.context = context;
    this.idRecept = idRecept;
    this.nazevrec = nazevrec;
    this.popis = popis;
    this.postupVareni = postupVareni;
    this.dobaVareniVMinutach = dobaVareniVMinutach;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.recept_id_txt.setText(String.valueOf(idRecept.get(position)));
        holder.recept_nazev_txt.setText(String.valueOf(nazevrec.get(position)));
        holder.recept_popis_txt.setText(String.valueOf(popis.get(position)));
        holder.recept_postupVareni_txt.setText(String.valueOf(postupVareni.get(position)));
        holder.recept_DobaVareni_txt.setText(String.valueOf(dobaVareniVMinutach.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RecipeViewer.class);

                intent.putExtra("id", String.valueOf(idRecept.get(position)));
                intent.putExtra("nazev", String.valueOf(nazevrec.get(position)));
                intent.putExtra("popis", String.valueOf(popis.get(position)));
                intent.putExtra("postupVareni", String.valueOf(postupVareni.get(position)));
                intent.putExtra("dobaVareniVMinutach", String.valueOf(dobaVareniVMinutach.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


        holder.recept_id_txt2.setText(String.valueOf(idRecept.get(position)));
        holder.recept_nazev_txt2.setText(String.valueOf(nazevrec.get(position)));
        holder.recept_popis_txt2.setText(String.valueOf(popis.get(position)));
        holder.recept_postupVareni_txt2.setText(String.valueOf(postupVareni.get(position)));
        holder.recept_DobaVareni_txt2.setText(String.valueOf(dobaVareniVMinutach.get(position)));
        holder.updateview_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(context, Update.class);

                intent2.putExtra("id2", String.valueOf(idRecept.get(position)));
                intent2.putExtra("nazev2", String.valueOf(nazevrec.get(position)));
                intent2.putExtra("popis2", String.valueOf(popis.get(position)));
                intent2.putExtra("postupVareni2", String.valueOf(postupVareni.get(position)));
                intent2.putExtra("dobaVareniVMinutach2", String.valueOf(dobaVareniVMinutach.get(position)));
                activity.startActivityForResult(intent2, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return idRecept.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView recept_id_txt, recept_nazev_txt, recept_popis_txt, recept_postupVareni_txt, recept_DobaVareni_txt;
        TextView recept_id_txt2, recept_nazev_txt2, recept_popis_txt2, recept_postupVareni_txt2, recept_DobaVareni_txt2;

        LinearLayout mainLayout;
        Button updateview_button;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            recept_id_txt = itemView.findViewById(R.id.recept_id_txt);
            recept_nazev_txt = itemView.findViewById(R.id.recept_nazev_txt);
            recept_popis_txt = itemView.findViewById(R.id.recept_popis_txt);
            recept_postupVareni_txt = itemView.findViewById(R.id.recept_postupVareni_txt);
            recept_DobaVareni_txt = itemView.findViewById(R.id.recept_DobaVareni_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
            recept_id_txt2 = itemView.findViewById(R.id.recept_id_txt);
            recept_nazev_txt2 = itemView.findViewById(R.id.recept_nazev_txt);
            recept_popis_txt2 = itemView.findViewById(R.id.recept_popis_txt);
            recept_postupVareni_txt2 = itemView.findViewById(R.id.recept_postupVareni_txt);
            recept_DobaVareni_txt2 = itemView.findViewById(R.id.recept_DobaVareni_txt);
            updateview_button = itemView.findViewById(R.id.updaterow_button);
        }
    }
}
