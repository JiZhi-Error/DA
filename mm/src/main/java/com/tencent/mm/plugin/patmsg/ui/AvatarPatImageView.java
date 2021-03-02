package com.tencent.mm.plugin.patmsg.ui;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.patmsg.a.c;
import com.tencent.mm.sdk.platformtools.Util;

public class AvatarPatImageView extends AppCompatImageView implements c {
    private c.a ARs;
    private View.OnClickListener ARt;
    public a ARu;

    public AvatarPatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AvatarPatImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(206974);
        this.ARu = new a();
        this.ARu.ARz = this;
        AppMethodBeat.o(206974);
    }

    public void setTagUsername(String str) {
        AppMethodBeat.i(206975);
        if (!Util.nullAsNil(getTagUsername()).equals(str)) {
            this.ARu.eBq();
        }
        setTag(R.id.g95, str);
        AppMethodBeat.o(206975);
    }

    @Override // com.tencent.mm.plugin.patmsg.a.c
    public String getTagUsername() {
        AppMethodBeat.i(206976);
        String str = (String) getTag(R.id.g95);
        AppMethodBeat.o(206976);
        return str;
    }

    public void setOnDoubleClickListener(c.a aVar) {
        this.ARs = aVar;
    }

    @Override // com.tencent.mm.plugin.patmsg.a.c
    public c.a getDoubleClickListener() {
        return this.ARs;
    }

    @Override // com.tencent.mm.plugin.patmsg.a.c
    public View.OnClickListener getOnClickListener() {
        return this.ARt;
    }

    public void setTagTalker(String str) {
        AppMethodBeat.i(206977);
        setTag(R.id.g94, str);
        AppMethodBeat.o(206977);
    }

    @Override // com.tencent.mm.plugin.patmsg.a.c
    public String getTagTalker() {
        AppMethodBeat.i(206978);
        if (getTag(R.id.g94) == null) {
            AppMethodBeat.o(206978);
            return "";
        }
        String str = (String) getTag(R.id.g94);
        AppMethodBeat.o(206978);
        return str;
    }

    public void setTagScene(int i2) {
        AppMethodBeat.i(206979);
        setTag(R.id.g93, Integer.valueOf(i2));
        AppMethodBeat.o(206979);
    }

    @Override // com.tencent.mm.plugin.patmsg.a.c
    public int getTagScene() {
        AppMethodBeat.i(206980);
        if (getTag(R.id.g93) == null) {
            AppMethodBeat.o(206980);
            return 0;
        }
        int intValue = ((Integer) getTag(R.id.g93)).intValue();
        AppMethodBeat.o(206980);
        return intValue;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        AppMethodBeat.i(206981);
        this.ARt = onClickListener;
        super.setOnClickListener(this.ARu.ARB);
        AppMethodBeat.o(206981);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(206982);
        super.onDetachedFromWindow();
        this.ARu.eBq();
        AppMethodBeat.o(206982);
    }
}
