package androidsample.test;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class AdapterSample extends ArrayAdapter<String> {

	public AdapterSample(Context context, int textViewResourceId, String[] objects) {
		super(context, textViewResourceId,objects);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	//1行分の表示を行うメソッド
	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {
		// TODO 自動生成されたメソッド・スタブ
		
		return super.getView(pos, convertView, parent);
	}

	
}
