package test.contactsample;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.view.Menu;
import android.widget.TextView;

public class ContactActivity extends Activity {

	private String getContactName(){
		ContentResolver cr = getContentResolver();
		Cursor cursorName = 
				cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
		Cursor cursorPhone =
				cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
						null, null, null, null);
		//query������ɓ��삷��ƁACursor�I�u�W�F�N�g���Ԃ����B
		String s = "\n";
		//�\����
		int nameIndexName = 
				cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
		int phoneIndexName = 
				cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
		if(cursorPhone.moveToFirst()){
			while(true){
				s += "���O�F"+ cursorPhone.getString(nameIndexName)+"  "
						+ cursorPhone.getString(phoneIndexName)+"\n";
				if(!cursorPhone.moveToNext())
					break;
			}
		}
		return s;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);
		String s = getContactName();
		TextView tv = (TextView)findViewById(R.id.textview);
		tv.setText(s);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact, menu);
		return true;
	}

}
