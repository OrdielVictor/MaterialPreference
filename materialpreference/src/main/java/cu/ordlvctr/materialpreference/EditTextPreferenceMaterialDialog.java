package cu.ordlvctr.materialpreference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.EditTextPreference;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class EditTextPreferenceMaterialDialog extends EditTextPreference {
	
	private String mHint;
	private TextInputLayout inputLayout;
	private TextInputEditText inputEditText;
	
	public EditTextPreferenceMaterialDialog(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.EditTextPreferenceMaterial, defStyleAttr, defStyleRes);
		
		mHint = TypedArrayUtils.getString(a, R.styleable.EditTextPreferenceMaterial_hint, R.styleable.EditTextPreferenceMaterial_android_hint);
		
		a.recycle();
	}
	
	public EditTextPreferenceMaterialDialog(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		this(context, attrs, defStyleAttr, 0);
	}
	
	public EditTextPreferenceMaterialDialog(@NonNull Context context, @Nullable AttributeSet attrs) {
		this(context, attrs, TypedArrayUtils.getAttr(context, androidx.preference.R.attr.editTextPreferenceStyle, android.R.attr.editTextPreferenceStyle));
	}
	
	public EditTextPreferenceMaterialDialog(@NonNull Context context) {
		this(context, null);
	}
	
	@Override
	protected void onClick() {
		View view = LayoutInflater.from(getContext()).inflate(R.layout.preference_edit_text_material_dialog, null, false);
		inputLayout = view.findViewById(R.id.text_input_layout);
		inputEditText = view.findViewById(R.id.text_input);
		
		inputLayout.setHint(getHint());
		inputEditText.setText(getText());
		
		AlertDialog.Builder builder = new MaterialAlertDialogBuilder(getContext());
		builder.setTitle(getDialogTitle());
		builder.setView(view);
		builder.setPositiveButton(android.R.string.ok, (dlg, which) -> {
			setText(inputEditText.getText().toString());
			String newValue = inputEditText.getText().toString().trim();
			if (callChangeListener(newValue)) {
				setText(newValue);
				notifyChanged();
			}
		});
		builder.setNegativeButton(android.R.string.cancel, null);
		builder.show();
	}
	
	private void setHint(String hint) {
		mHint = hint;
	}
	
	private String getHint() {
		return mHint;
	}
}
