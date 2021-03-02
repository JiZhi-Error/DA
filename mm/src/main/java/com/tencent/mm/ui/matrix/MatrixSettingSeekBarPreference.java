package com.tencent.mm.ui.matrix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class MatrixSettingSeekBarPreference extends Preference {
    int KVM = 700;
    a QmR;
    private SeekBar oyP;

    /* access modifiers changed from: package-private */
    public interface a {
        void aok(int i2);
    }

    public MatrixSettingSeekBarPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public MatrixSettingSeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(38885);
        super.onBindView(view);
        this.oyP = (SeekBar) view.findViewById(R.id.im5);
        this.oyP.setProgress((int) ((100.0f * ((float) this.KVM)) / 5000.0f));
        final TextView textView = (TextView) view.findViewById(R.id.e58);
        textView.setText(this.mContext.getResources().getString(R.string.eyv, Integer.valueOf(this.KVM)));
        this.oyP.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /* class com.tencent.mm.ui.matrix.MatrixSettingSeekBarPreference.AnonymousClass1 */

            public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                AppMethodBeat.i(38883);
                MatrixSettingSeekBarPreference.this.KVM = Math.max(17, (int) ((5000.0f * ((float) i2)) / 100.0f));
                textView.setText(MatrixSettingSeekBarPreference.this.mContext.getResources().getString(R.string.eyv, Integer.valueOf(MatrixSettingSeekBarPreference.this.KVM)));
                AppMethodBeat.o(38883);
            }

            public final void onStartTrackingTouch(SeekBar seekBar) {
            }

            public final void onStopTrackingTouch(SeekBar seekBar) {
                AppMethodBeat.i(38884);
                if (MatrixSettingSeekBarPreference.this.QmR != null) {
                    MatrixSettingSeekBarPreference.this.QmR.aok(MatrixSettingSeekBarPreference.this.KVM);
                }
                AppMethodBeat.o(38884);
            }
        });
        AppMethodBeat.o(38885);
    }
}
