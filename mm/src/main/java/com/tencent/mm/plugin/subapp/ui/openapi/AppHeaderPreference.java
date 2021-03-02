package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.u;
import junit.framework.Assert;

public class AppHeaderPreference extends Preference {
    private a FMq;
    private boolean eeO = false;
    private TextView gCd;
    private ImageView gyr;
    private boolean kac = false;
    private TextView kib;
    private TextView kuu;

    public interface a {
        String ftq();

        Bitmap ftr();

        String getHint();

        String wf(boolean z);
    }

    public AppHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppHeaderPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(29133);
        this.gyr = (ImageView) view.findViewById(R.id.baa);
        this.gCd = (TextView) view.findViewById(R.id.bbn);
        this.kib = (TextView) view.findViewById(R.id.bb8);
        this.kuu = (TextView) view.findViewById(R.id.bau);
        this.kac = true;
        if (!this.kac || this.FMq == null) {
            Log.w("MicroMsg.HeaderPreference", "initView : bindView = " + this.kac);
        } else {
            Bitmap ftr = this.FMq.ftr();
            if (!(this.gyr == null || ftr == null || ftr.isRecycled())) {
                this.gyr.setImageBitmap(ftr);
            }
            String ftq = this.FMq.ftq();
            if (!(this.kib == null || ftq == null || ftq.length() <= 0)) {
                this.kib.setText(ftq);
            }
            String hint = this.FMq.getHint();
            if (hint != null) {
                this.kuu.setText(hint);
                this.kuu.setVisibility(0);
            } else {
                this.kuu.setVisibility(8);
            }
            boolean z = this.eeO;
            if (this.gCd != null) {
                String wf = this.FMq.wf(z);
                if (z) {
                    if (wf == null || wf.length() <= 0) {
                        this.gCd.setVisibility(8);
                    } else {
                        this.gCd.setTextColor(u.kF(this.mContext));
                        this.gCd.setText(wf);
                        this.gCd.setCompoundDrawablesWithIntrinsicBounds(R.drawable.bo8, 0, 0, 0);
                    }
                } else if (wf == null || wf.length() <= 0) {
                    this.gCd.setVisibility(8);
                } else {
                    this.gCd.setTextColor(u.kG(this.mContext));
                    this.gCd.setText(wf);
                    this.gCd.setCompoundDrawablesWithIntrinsicBounds(R.drawable.bo7, 0, 0, 0);
                }
            }
        }
        super.onBindView(view);
        AppMethodBeat.o(29133);
    }

    public final void a(a aVar, boolean z) {
        AppMethodBeat.i(29134);
        Assert.assertTrue(aVar != null);
        this.FMq = aVar;
        this.eeO = z;
        AppMethodBeat.o(29134);
    }
}
