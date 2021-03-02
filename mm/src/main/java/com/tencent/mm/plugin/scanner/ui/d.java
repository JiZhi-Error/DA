package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public final class d extends Preference {
    private TextView BfZ;
    private final int CKr = 5;
    private TextView CKs;
    public boolean CKt = false;
    public boolean CKu = false;
    private Boolean CKv;
    private ViewTreeObserver.OnGlobalLayoutListener CKw;
    a CKx;
    private View.OnTouchListener aZa;
    private Context context;
    String mTitle;
    private View mView;
    private TextView titleTv;

    public interface a {
        Boolean aMH(String str);

        void b(String str, Boolean bool);

        void eQI();
    }

    public d(Activity activity) {
        super(activity);
        AppMethodBeat.i(51791);
        setLayoutResource(R.layout.b9v);
        this.context = activity;
        AppMethodBeat.o(51791);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(51792);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(51792);
        return view2;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(51793);
        super.onBindView(view);
        if (this.titleTv == null) {
            this.titleTv = (TextView) view.findViewById(16908310);
        }
        if (this.BfZ == null) {
            this.BfZ = (TextView) view.findViewById(16908304);
        }
        if (this.CKs == null) {
            this.CKs = (TextView) view.findViewById(R.id.fjn);
        }
        if (this.aZa == null) {
            this.aZa = new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.scanner.ui.d.AnonymousClass1 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(51789);
                    if (motionEvent.getAction() == 0) {
                        Log.d("MicroMsg.scanner.PlainTextPreference", "moreTv onTouch");
                        d.this.CKs.setVisibility(4);
                        d.this.BfZ.setMaxLines(2000);
                        d.this.CKt = true;
                        if (d.this.CKx != null) {
                            d.this.CKx.b(d.this.mKey, Boolean.TRUE);
                            d.this.CKx.eQI();
                        }
                    }
                    AppMethodBeat.o(51789);
                    return false;
                }
            };
            this.CKs.setOnTouchListener(this.aZa);
        }
        if (this.CKx != null) {
            this.CKv = this.CKx.aMH(this.mKey);
            if (this.CKv == null) {
                this.CKs.setVisibility(8);
                this.BfZ.setMaxLines(6);
            } else if (this.CKv.booleanValue()) {
                this.CKs.setVisibility(8);
                this.BfZ.setMaxLines(2000);
            } else {
                this.CKs.setVisibility(0);
                this.BfZ.setMaxLines(5);
            }
        } else {
            this.CKs.setVisibility(8);
            this.BfZ.setMaxLines(6);
        }
        if (this.CKw == null) {
            this.CKw = new ViewTreeObserver.OnGlobalLayoutListener() {
                /* class com.tencent.mm.plugin.scanner.ui.d.AnonymousClass2 */

                public final void onGlobalLayout() {
                    AppMethodBeat.i(51790);
                    Log.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() = " + d.this.BfZ.getHeight() + ", summaryTv.getLineHeight() = " + d.this.BfZ.getLineHeight());
                    if (d.this.BfZ.getText() != null && d.this.BfZ.getHeight() > 0 && d.this.BfZ.getLineHeight() > 0 && d.this.CKv == null) {
                        if (d.this.BfZ.getHeight() / d.this.BfZ.getLineHeight() > 5 && !d.this.CKu && !d.this.CKt) {
                            d.this.CKs.setVisibility(0);
                            d.this.BfZ.setMaxLines(5);
                            d.this.CKu = true;
                            if (d.this.CKx != null && d.this.CKx.aMH(d.this.mKey) == null) {
                                d.this.CKx.b(d.this.mKey, Boolean.FALSE);
                                d.this.CKx.eQI();
                            }
                        }
                        Log.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() / summaryTv.getLineHeight() = " + (d.this.BfZ.getHeight() / d.this.BfZ.getLineHeight()));
                    }
                    d.this.BfZ.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    AppMethodBeat.o(51790);
                }
            };
            this.BfZ.getViewTreeObserver().addOnGlobalLayoutListener(this.CKw);
        }
        if (Util.isNullOrNil(this.mTitle)) {
            this.titleTv.setVisibility(8);
            AppMethodBeat.o(51793);
            return;
        }
        this.titleTv.setText(this.mTitle);
        this.titleTv.setVisibility(0);
        AppMethodBeat.o(51793);
    }
}
