package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.contact.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cn;
import org.xwalk.core.Log;

public class ProfileDescribeView extends ProfileItemView {
    public TextView KcG;
    public TextView KcH;

    public ProfileDescribeView(Context context) {
        super(context);
    }

    public ProfileDescribeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ProfileDescribeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.tencent.mm.pluginsdk.ui.ProfileItemView
    public int getLayout() {
        return R.layout.bje;
    }

    @Override // com.tencent.mm.pluginsdk.ui.ProfileItemView
    public final void init() {
        AppMethodBeat.i(31210);
        this.KcG = (TextView) findViewById(R.id.bam);
        this.KcH = (TextView) findViewById(R.id.ban);
        setClickable(true);
        AppMethodBeat.o(31210);
    }

    @Override // com.tencent.mm.pluginsdk.ui.ProfileItemView
    public final boolean eEV() {
        AppMethodBeat.i(31211);
        if (this.KcH != null) {
            ViewGroup.LayoutParams layoutParams = this.KcH.getLayoutParams();
            layoutParams.width = a.aG(getContext(), R.dimen.em);
            this.KcH.setLayoutParams(layoutParams);
        }
        if (this.rjX == null) {
            setVisibility(8);
            AppMethodBeat.o(31211);
            return false;
        }
        String str = this.rjX.fuR;
        boolean z = !Util.isNullOrNil(this.rjX.fuS);
        if (!c.oR(this.rjX.field_type)) {
            cn cnVar = null;
            String str2 = this.rjX.field_encryptUsername;
            if (!Util.isNullOrNil(str2)) {
                bg.aVF();
                cnVar = com.tencent.mm.model.c.aSO().aEZ(str2);
            }
            if (cnVar != null && cnVar.systemRowid < 0) {
                bg.aVF();
                cnVar = com.tencent.mm.model.c.aSO().aEZ(this.rjX.field_username);
            }
            if (cnVar == null || Util.isNullOrNil(cnVar.field_conDescription)) {
                Log.i("MicroMsg.ProfileDescribeView", "ProfileDescribeView gone");
                setVisibility(8);
                AppMethodBeat.o(31211);
                return false;
            }
            this.KcG.setText(l.b(getContext(), Util.nullAsNil(cnVar.field_conDescription), this.KcG.getTextSize()));
            AppMethodBeat.o(31211);
            return true;
        } else if (!Util.isNullOrNil(str) && z) {
            Drawable drawable = getContext().getResources().getDrawable(R.raw.card_photoicon);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable, 1);
            aVar.QBM = (int) ((((float) drawable.getIntrinsicHeight()) - this.KcG.getTextSize()) / 2.0f);
            SpannableString spannableString = new SpannableString("  ".concat(String.valueOf(str)));
            spannableString.setSpan(aVar, 0, 1, 33);
            this.KcG.setText(l.b(getContext(), spannableString, this.KcG.getTextSize()));
            AppMethodBeat.o(31211);
            return true;
        } else if (!Util.isNullOrNil(str) && !z) {
            this.KcG.setText(l.b(getContext(), Util.nullAsNil(str), this.KcG.getTextSize()));
            AppMethodBeat.o(31211);
            return true;
        } else if (Util.isNullOrNil(str) && z) {
            Drawable drawable2 = getContext().getResources().getDrawable(R.raw.card_photoicon);
            drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
            com.tencent.mm.ui.widget.a aVar2 = new com.tencent.mm.ui.widget.a(drawable2, 1);
            aVar2.QBM = (int) ((((float) drawable2.getIntrinsicHeight()) - this.KcG.getTextSize()) / 2.0f);
            SpannableString spannableString2 = new SpannableString("  " + getContext().getString(R.string.bes));
            spannableString2.setSpan(aVar2, 0, 1, 33);
            this.KcG.setText(l.b(getContext(), spannableString2, this.KcG.getTextSize()));
            AppMethodBeat.o(31211);
            return true;
        } else if (!Util.isNullOrNil(str) || z) {
            Log.i("MicroMsg.ProfileDescribeView", "ProfileDescribeView gone,isContact");
            setVisibility(8);
            AppMethodBeat.o(31211);
            return false;
        } else {
            Log.i("MicroMsg.ProfileDescribeView", "ProfileDescribeView gone,isContact");
            setVisibility(8);
            AppMethodBeat.o(31211);
            return false;
        }
    }
}
