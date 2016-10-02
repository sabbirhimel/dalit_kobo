package org.odk.collect.android.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.koboc.collect.android.R;
import org.odk.collect.android.model.Case_status;

import java.util.ArrayList;


/**
 * Created by raihan on 9/29/16.
 */

public class question_status_list_Activity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.case_status_list);
          // now it will not fail here
    }
    public class UsersAdapter extends ArrayAdapter<Case_status> {
        public UsersAdapter(Context context, ArrayList<Case_status> users) {
            super(context, 0, users);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            final Case_status user = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.case_status_row, parent, false);
            }
            // Lookup view for data population
            TextView caseID = (TextView) convertView.findViewById(R.id.caseID);
            TextView caseName = (TextView) convertView.findViewById(R.id.casename);
            TextView caseStatus = (TextView) convertView.findViewById(R.id.casestatus);
            // Populate the data into the template view using the data object
            caseID.setText(user.getCase_id());
            caseName.setText(user.getCase_name());
            caseStatus.setText(user.getCase_status());
            caseStatus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(question_status_list_Activity.this);
                    builder.setMessage(user.getCase_status_details())
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    //do things
                                    dialog.dismiss();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.setTitle("Case Status");
                    alert.show();
                }
            });
            // Return the completed view to render on screen
            return convertView;
        }
    }
}
