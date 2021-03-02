package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;

public class ContactCountView extends FrameLayout {
    private int PUr = 1;
    private int count = 0;
    private View jxm;
    private boolean nsS = false;
    private boolean visible = true;
    private TextView yul;

    public ContactCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(37722);
        init();
        AppMethodBeat.o(37722);
    }

    public ContactCountView(Context context) {
        super(context);
        AppMethodBeat.i(37723);
        init();
        AppMethodBeat.o(37723);
    }

    private void init() {
        AppMethodBeat.i(37724);
        inflate(getContext(), R.layout.wa, this);
        AppMethodBeat.o(37724);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(37725);
        Log.d("MicroMsg.ContactCountView", "onMeasure");
        if (this.jxm == null) {
            this.jxm = (FrameLayout) findViewById(R.id.ba6);
            this.yul = (TextView) findViewById(R.id.ba5);
        }
        gUw();
        super.onMeasure(i2, i3);
        AppMethodBeat.o(37725);
    }

    public void setContactType(int i2) {
        this.PUr = i2;
    }

    public final void gUw() {
        AppMethodBeat.i(37726);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.ui.contact.ContactCountView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(233997);
                if (!ContactCountView.this.nsS) {
                    String[] strArr = ab.iCO;
                    if (ContactCountView.this.PUr == 1) {
                        ContactCountView contactCountView = ContactCountView.this;
                        bg.aVF();
                        contactCountView.count = c.aSN().c(strArr, z.aTY(), "weixin", "helper_entry", "filehelper");
                    } else {
                        ContactCountView contactCountView2 = ContactCountView.this;
                        bg.aVF();
                        contactCountView2.count = c.aSN().d(strArr, z.aTY(), "weixin", "helper_entry", "filehelper");
                    }
                }
                Log.d("MicroMsg.ContactCountView", "contact count %d", Integer.valueOf(ContactCountView.this.count));
                ContactCountView.this.post(new Runnable() {
                    /* class com.tencent.mm.ui.contact.ContactCountView.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(233996);
                        if (ContactCountView.this.yul != null) {
                            if (ContactCountView.this.PUr == 1) {
                                ContactCountView.this.yul.setText(ContactCountView.this.getContext().getResources().getQuantityString(R.plurals.f3135b, ContactCountView.this.count, Integer.valueOf(ContactCountView.this.count)));
                            } else {
                                ContactCountView.this.yul.setText(ContactCountView.this.getContext().getResources().getQuantityString(R.plurals.f3134a, ContactCountView.this.count, Integer.valueOf(ContactCountView.this.count)));
                            }
                        }
                        ContactCountView.this.setVisible(ContactCountView.this.visible);
                        AppMethodBeat.o(233996);
                    }
                });
                AppMethodBeat.o(233997);
            }
        });
        AppMethodBeat.o(37726);
    }

    public void setFixedContactCount(int i2) {
        AppMethodBeat.i(180043);
        this.nsS = true;
        this.count = i2;
        gUw();
        AppMethodBeat.o(180043);
    }

    public void setVisible(boolean z) {
        AppMethodBeat.i(37727);
        this.visible = z;
        if (this.jxm != null) {
            this.jxm.setVisibility((!z || this.count <= 0) ? 8 : 0);
        }
        AppMethodBeat.o(37727);
    }
}
