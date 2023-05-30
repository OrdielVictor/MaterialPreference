package cu.ordlvctr.materialpreference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.DialogTitle;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.EditTextPreference;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class EditTextPreferenceMaterial extends EditTextPreference {
	
	private String mHint;
	private DialogTitle title;
	private TextInputLayout inputLayout;
	private TextInputEditText inputEditText;
	private MaterialButton positiveButton, negativeButton;
	
	public EditTextPreferenceMaterial(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.EditTextPreferenceMaterial, defStyleAttr, defStyleRes);
		
		mHint = TypedArrayUtils.getString(a, R.styleable.EditTextPreferenceMaterial_hint, R.styleable.EditTextPreferenceMaterial_android_hint);
		
		a.recycle();
	}
	
	public EditTextPreferenceMaterial(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		this(context, attrs, defStyleAttr, 0);
	}
	
	public EditTextPreferenceMaterial(@NonNull Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, TypedArrayUtils.getAttr(context, androidx.preference.R.attr.editTextPreferenceStyle, android.R.attr.editTextPreferenceStyle));
	}
	
	public EditTextPreferenceMaterial(@NonNull Context context) {
		this(context, null);
	}
	
	@Override
	protected void onClick() {
		BottomSheetDialog dialog = new BottomSheetDialog(getContext());
		View view = LayoutInflater.from(getContext()).inflate(R.layout.preference_edit_text_material, null, false);
		dialog.setContentView(view);
		
		title = view.findViewById(android.R.id.title);
		inputLayout = view.findViewById(R.id.text_input_layout);
		inputEditText = view.findViewById(R.id.text_input);
		positiveButton = view.findViewById(android.R.id.button1);
		negativeButton = view.findViewById(android.R.id.button2);
		
		title.setText(getDialogTitle());
		inputLayout.setHint(getHint());
		inputEditText.setText(getText());
		
		positiveButton.setOnClickListener(v -> {
			setText(inputEditText.getText().toString());
			String newValue = inputEditText.getText().toString().trim();
			if (callChangeListener(newValue)) {
				setText(newValue);
				notifyChanged();
				dialog.dismiss();
			}
		});
		
		negativeButton.setOnClickListener(v -> {
			dialog.dismiss();
		});
		
		dialog.show();
	}
	
	private void setHint(String hint) {
		mHint = hint;
	}
	
	private String getHint() {
		return mHint;
	}
}
