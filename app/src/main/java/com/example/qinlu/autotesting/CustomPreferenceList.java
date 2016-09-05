package com.example.qinlu.autotesting;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.app.AlertDialog.Builder;
/**
 * Created by qinlu on 9/5/2016.
 */
public class CustomPreferenceList extends ListPreference implements OnClickListener{

    private int mClickedDialogEntryIndex;

    public CustomPreferenceList(Context context, AttributeSet attrs) {
        super(context, attrs);


    }

    public CustomPreferenceList(Context context) {
        this(context, null);
    }

    private int getValueIndex() {
        return findIndexOfValue(this.getValue() +"");
    }


    @Override
    protected void onPrepareDialogBuilder(Builder builder) {
        super.onPrepareDialogBuilder(builder);

        mClickedDialogEntryIndex = getValueIndex();
        builder.setSingleChoiceItems(this.getEntries(), mClickedDialogEntryIndex, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                mClickedDialogEntryIndex = which;

            }
        });

        System.out.println(getEntry() + " " + this.getEntries()[0]);
        builder.setPositiveButton("OK", this);
    }

    public  void onClick (DialogInterface dialog, int which)
    {
        this.setValue(this.getEntryValues()[mClickedDialogEntryIndex]+"");
    }

}