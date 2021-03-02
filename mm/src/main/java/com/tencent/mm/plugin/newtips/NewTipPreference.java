package com.tencent.mm.plugin.newtips;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.newtips.a.a;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.plugin.newtips.b;
import com.tencent.mm.protocal.protobuf.ehv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.lang.ref.WeakReference;

public class NewTipPreference extends Preference implements a {
    private WeakReference<f> ACF;
    private Context context;
    private View gvQ;
    private View hbJ;
    private View mView;
    private String path;

    public NewTipPreference(Context context2, AttributeSet attributeSet) {
        this(context2, attributeSet, 0);
    }

    public NewTipPreference(Context context2, AttributeSet attributeSet, int i2) {
        super(context2, attributeSet, i2);
        AppMethodBeat.i(184011);
        this.ACF = null;
        this.context = context2;
        setLayoutResource(R.layout.b8j);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, b.a.NormalIconNewTipPreference, i2, 0);
        this.path = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
        Log.i("MicroMsg.NewTips.NewTipPreference", "NewTipPreference() path:%s", this.path);
        AppMethodBeat.o(184011);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(184012);
        View onCreateView = super.onCreateView(viewGroup);
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
        viewGroup2.removeAllViews();
        View.inflate(this.mContext, R.layout.b_k, viewGroup2);
        this.mView = onCreateView;
        View view = this.mView;
        AppMethodBeat.o(184012);
        return view;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(184013);
        super.onBindView(view);
        this.hbJ = view.findViewById(R.id.gy4);
        i.TD(g.aIB(this.path));
        AppMethodBeat.o(184013);
    }

    public final boolean exi() {
        AppMethodBeat.i(188555);
        if (this.hbJ == null) {
            AppMethodBeat.o(188555);
            return false;
        } else if (this.hbJ.getVisibility() == 0) {
            AppMethodBeat.o(188555);
            return true;
        } else {
            AppMethodBeat.o(188555);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final String getPath() {
        return this.path;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean ehp() {
        return false;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final View getRoot() {
        AppMethodBeat.i(184014);
        if (this.gvQ == null) {
            this.gvQ = new View(this.context);
        }
        View view = this.gvQ;
        AppMethodBeat.o(184014);
        return view;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final void a(k kVar, boolean z) {
        AppMethodBeat.i(184015);
        g.a(this, kVar, z);
        AppMethodBeat.o(184015);
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean qV(boolean z) {
        AppMethodBeat.i(184016);
        boolean a2 = g.a(z, this);
        AppMethodBeat.o(184016);
        return a2;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean qW(boolean z) {
        boolean z2;
        f fVar;
        AppMethodBeat.i(184017);
        Log.d("MicroMsg.NewTips.NewTipPreference", "showRedPoint() show:%s", Boolean.valueOf(z));
        if (this.hbJ == null) {
            z2 = false;
        } else {
            if (z) {
                this.hbJ.setVisibility(0);
            } else {
                this.hbJ.setVisibility(8);
            }
            z2 = true;
        }
        if (z2) {
            if (!(this.ACF == null || (fVar = this.ACF.get()) == null)) {
                fVar.notifyDataSetChanged();
            }
            AppMethodBeat.o(184017);
            return true;
        }
        AppMethodBeat.o(184017);
        return false;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean qX(boolean z) {
        return false;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean a(boolean z, ehv ehv) {
        return false;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean b(boolean z, ehv ehv) {
        return false;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean c(boolean z, ehv ehv) {
        return false;
    }

    @Override // com.tencent.mm.plugin.newtips.a.a
    public final boolean d(boolean z, ehv ehv) {
        return false;
    }

    public final void a(f fVar) {
        AppMethodBeat.i(184018);
        this.ACF = new WeakReference<>(fVar);
        AppMethodBeat.o(184018);
    }
}
