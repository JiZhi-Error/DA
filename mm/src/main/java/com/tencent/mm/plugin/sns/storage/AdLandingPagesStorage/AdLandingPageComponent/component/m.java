package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.VideoFullScreenActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m {
    int Dzo = 0;
    protected z EcX;
    private long EcY = 0;
    boolean EcZ = false;
    protected ViewGroup Eda;
    protected int backgroundColor;
    public View contentView = null;
    public Context context;
    private long dUy = 0;
    protected int mEX;
    protected int mEY;

    public m(Context context2, z zVar, ViewGroup viewGroup) {
        AppMethodBeat.i(96466);
        this.context = context2;
        this.EcX = zVar;
        this.Eda = viewGroup;
        int[] ha = ap.ha(context2);
        this.mEX = ha[0];
        this.mEY = ha[1];
        if (ao.aQ(context2)) {
            this.mEY -= ao.aP(context2);
        }
        AppMethodBeat.o(96466);
    }

    public final void setBackgroundColor(int i2) {
        this.backgroundColor = i2;
    }

    public final View getView() {
        AppMethodBeat.i(96468);
        if (this.contentView != null) {
            View view = this.contentView;
            AppMethodBeat.o(96468);
            return view;
        }
        if (this.contentView == null) {
            int layout = getLayout();
            if (layout != Integer.MAX_VALUE) {
                this.contentView = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(layout, this.Eda, false);
            } else {
                this.contentView = eWY();
                if (this.contentView != null && this.contentView.getLayoutParams() == null) {
                    this.Eda.addView(this.contentView);
                    ViewGroup.LayoutParams layoutParams = this.contentView.getLayoutParams();
                    this.Eda.removeView(this.contentView);
                    this.contentView.setLayoutParams(layoutParams);
                }
            }
            if (this.contentView == null) {
                IllegalStateException illegalStateException = new IllegalStateException("implement getLayout() or customLayout() to get a valid root view");
                AppMethodBeat.o(96468);
                throw illegalStateException;
            }
        }
        eXe();
        eWT();
        eWX();
        fdp();
        View view2 = this.contentView;
        AppMethodBeat.o(96468);
        return view2;
    }

    public final z fdk() {
        return this.EcX;
    }

    public void eXe() {
    }

    /* access modifiers changed from: protected */
    public void eWT() {
        AppMethodBeat.i(96469);
        Log.w("MicroMsg.Sns.AdLandingPageBaseComponent", "for component reuse, subclass must implement this method");
        AppMethodBeat.o(96469);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return Integer.MAX_VALUE;
    }

    /* access modifiers changed from: protected */
    public View eWY() {
        return null;
    }

    public void eWZ() {
        AppMethodBeat.i(96470);
        if (this.EcZ) {
            AppMethodBeat.o(96470);
            return;
        }
        this.EcZ = true;
        this.EcY = System.currentTimeMillis();
        this.Dzo++;
        AppMethodBeat.o(96470);
    }

    public void eXa() {
        AppMethodBeat.i(96471);
        if (!this.EcZ) {
            AppMethodBeat.o(96471);
            return;
        }
        this.EcZ = false;
        if (this.EcY > 0) {
            this.dUy += System.currentTimeMillis() - this.EcY;
        }
        this.EcY = 0;
        AppMethodBeat.o(96471);
    }

    public void eXb() {
    }

    public final int fdl() {
        AppMethodBeat.i(96472);
        View view = getView();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        int height = view.getHeight() + i2;
        Log.d("MicroMsg.Sns.AdLandingPageBaseComponent", "comp %s , top %d,bottom %d ", this, Integer.valueOf(i2), Integer.valueOf(height));
        if (i2 >= 0 && height <= this.mEY) {
            height = view.getHeight();
        } else if (i2 >= 0 || height <= 0 || height > this.mEY) {
            if (i2 >= 0 || height <= this.mEY) {
                height = (i2 >= this.mEY || height <= this.mEY) ? 0 : this.mEY - i2;
            } else {
                height = this.mEY;
            }
        }
        AppMethodBeat.o(96472);
        return height;
    }

    public boolean fdm() {
        AppMethodBeat.i(96473);
        if (fdl() >= Math.min(getView().getHeight() >>> 1, this.mEY >>> 1)) {
            AppMethodBeat.o(96473);
            return true;
        }
        AppMethodBeat.o(96473);
        return false;
    }

    public void eXd() {
        AppMethodBeat.i(96474);
        eXa();
        AppMethodBeat.o(96474);
    }

    public final String fdn() {
        return this.EcX.DZi;
    }

    public long fdo() {
        return this.dUy;
    }

    public boolean G(JSONArray jSONArray) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void eWX() {
    }

    public final void fdp() {
        AppMethodBeat.i(96476);
        if (this.contentView == null) {
            IllegalStateException illegalStateException = new IllegalStateException("set field contentView first");
            AppMethodBeat.o(96476);
            throw illegalStateException;
        }
        if (this.EcX != null) {
            ViewGroup.LayoutParams layoutParams = this.contentView.getLayoutParams();
            if (layoutParams != null) {
                if (this.EcX.DZk != 2.14748365E9f) {
                    layoutParams.width = (int) this.EcX.DZk;
                }
                if (this.EcX.DZl != 2.14748365E9f) {
                    layoutParams.height = (int) this.EcX.DZl;
                }
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    int gravity = getGravity();
                    if (gravity != 0) {
                        layoutParams2.gravity = gravity;
                    }
                } else if (layoutParams instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams;
                    int gravity2 = getGravity();
                    if (gravity2 != 0) {
                        layoutParams3.gravity = gravity2;
                    }
                }
                this.contentView.setLayoutParams(layoutParams);
                AppMethodBeat.o(96476);
                return;
            }
            Log.i("MicroMsg.Sns.AdLandingPageBaseComponent", this + " has no layoutParams in container " + this.Eda);
        }
        AppMethodBeat.o(96476);
    }

    public final int getGravity() {
        int i2 = 0;
        switch (this.EcX.DZo) {
            case 0:
                i2 = 48;
                break;
            case 1:
                i2 = 16;
                break;
            case 2:
                i2 = 80;
                break;
        }
        switch (this.EcX.DZp) {
            case 0:
                return i2 | 3;
            case 1:
                return i2 | 1;
            case 2:
                return i2 | 5;
            default:
                return i2;
        }
    }

    public void aQ(Map<String, Object> map) {
    }

    public void fdq() {
    }

    /* access modifiers changed from: protected */
    public final <T> T fdr() {
        try {
            return (T) this.EcX;
        } catch (Exception e2) {
            return null;
        }
    }

    public final ah fds() {
        AppMethodBeat.i(96477);
        if (this.context instanceof SnsAdNativeLandingPagesUI) {
            ah fds = ((SnsAdNativeLandingPagesUI) this.context).fds();
            AppMethodBeat.o(96477);
            return fds;
        } else if (this.context instanceof VideoFullScreenActivity) {
            ah fcZ = VideoFullScreenActivity.fcZ();
            AppMethodBeat.o(96477);
            return fcZ;
        } else {
            ah ahVar = new ah();
            AppMethodBeat.o(96477);
            return ahVar;
        }
    }

    public void b(z zVar) {
        AppMethodBeat.i(96467);
        z zVar2 = this.EcX;
        if (zVar2 == zVar) {
            AppMethodBeat.o(96467);
        } else if (zVar2 == null || !zVar2.equals(zVar)) {
            this.EcX = zVar;
            eWT();
            fdp();
            AppMethodBeat.o(96467);
        } else {
            AppMethodBeat.o(96467);
        }
    }

    public boolean bp(JSONObject jSONObject) {
        AppMethodBeat.i(96475);
        if (this.Dzo == 0) {
            AppMethodBeat.o(96475);
            return false;
        } else if (this.EcX.DZr) {
            AppMethodBeat.o(96475);
            return false;
        } else {
            try {
                jSONObject.put("cid", this.EcX.DZi);
                jSONObject.put(f.COL_EXPOSURECOUNT, this.Dzo);
                jSONObject.put("stayTime", fdo());
                AppMethodBeat.o(96475);
                return true;
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.Sns.AdLandingPageBaseComponent", e2, "", new Object[0]);
                AppMethodBeat.o(96475);
                return false;
            }
        }
    }
}
