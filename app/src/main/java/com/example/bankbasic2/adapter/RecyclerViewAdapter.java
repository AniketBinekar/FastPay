package com.example.bankbasic2.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bankbasic2.DisplayAccount;
import com.example.bankbasic2.R;
import com.example.bankbasic2.model.Accounts;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Accounts> accountsList;

    public RecyclerViewAdapter(Context context, List<Accounts> accountsList)
    {
        this.context = context;
        this.accountsList=accountsList;
    }


    //Where will the card come from?
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    //What to write in the card?
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position)
    {
        Accounts accounts=accountsList.get(position);

        holder.AccountName.setText(accounts.getName());
        holder.AccountNumber.setText(accounts.getEmail());
    }

//How many items are present in the list?
    @Override
    public int getItemCount()
    {
        return accountsList.size();
    }


    //To perform actions on clicking on the class
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView AccountName;
        public TextView AccountNumber;
        public ImageView Next;


        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);

            AccountName = itemView.findViewById(R.id.dName);
            AccountNumber = itemView.findViewById(R.id.Acc_number);
            
        }

        @Override
        public void onClick(View v)
        {
            int position = this.getAdapterPosition();
            Accounts accounts=accountsList.get(position);
            String name=accounts.getName();
            int Acc_no=accounts.getId1();
            String Email=accounts.getEmail();
            String Phone=accounts.getPhone();
            int Balance=accounts.getBalance();
            Toast.makeText(context,"The position is "+String.valueOf(position)+"\nAccount: "+String.valueOf(Acc_no),Toast.LENGTH_SHORT).show();
            Log.d("Amt", String.valueOf(Balance));

            Intent intent=new Intent(context, DisplayAccount.class);
            intent.putExtra("RName",name);
            intent.putExtra("RAccount",String.valueOf(Acc_no));
            intent.putExtra("REmail",Email);
            intent.putExtra("RPhone",Phone);
            intent.putExtra("RBalance",String.valueOf(Balance));
            context.startActivity(intent);

        }
    }
}
