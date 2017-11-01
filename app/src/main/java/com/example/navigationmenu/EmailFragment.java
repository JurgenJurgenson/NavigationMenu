package com.example.navigationmenu;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EmailFragment extends Fragment {
    //Creating variables:
    EditText editEmail, editSubject, editMessage;
    Button btn_Send;

    public EmailFragment() {}

    //Override method:
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_email, container, false);

        editEmail = (EditText) view.findViewById(R.id.editEmail); //Finds EditText variable with name editEmail
        editSubject = (EditText) view.findViewById(R.id.editSubject); //Finds EditText variable with name editSubject
        editMessage = (EditText) view.findViewById(R.id.editMessage); //Finds EditText variable with name editMessage
        btn_Send = (Button) view.findViewById(R.id.btn_send); //Finds Button variable with name btn_send
        btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to = editEmail.getText().toString(); //Changes editEmail variable type to String
                String subject = editSubject.getText().toString(); //Changes editSubject variable type to String
                String message = editMessage.getText().toString(); //Changes editMessage variable type to String

                //Create abstract Intent which achieves email:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, message);

                intent.setType("message/rfc822"); //Tie Abstract intent type to 'message/rfc822'

                startActivity(Intent.createChooser(intent, "Select Email app")); //Gives choice which email app you want to use.
            }
        });
        return view; //Return view
    }
}
