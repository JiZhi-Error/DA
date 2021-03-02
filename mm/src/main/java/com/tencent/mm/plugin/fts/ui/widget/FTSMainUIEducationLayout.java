package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.service.x;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.b.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class FTSMainUIEducationLayout extends LinearLayout {
    boolean UWZ = false;
    private float mFs = ((float) ViewConfiguration.get(getContext()).getScaledTouchSlop());
    protected View.OnClickListener xcf;
    protected List<LinearLayout> xeS;
    protected Map<Integer, TextView> xeT = new HashMap();
    private String xeU = "";
    private boolean xeV = true;
    protected boolean xeW = true;
    private boolean xeX;
    public View.OnClickListener xeY;
    private View.OnClickListener xeZ;

    public FTSMainUIEducationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(112267);
        initView();
        AppMethodBeat.o(112267);
    }

    public FTSMainUIEducationLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(112268);
        initView();
        AppMethodBeat.o(112268);
    }

    private void initView() {
        AppMethodBeat.i(112269);
        setOrientation(1);
        this.xeS = new ArrayList();
        AppMethodBeat.o(112269);
    }

    public void setNeedHotWord(boolean z) {
        this.xeW = z;
    }

    public void setNeedWXAPP(boolean z) {
        this.xeX = z;
    }

    private void dPK() {
        AppMethodBeat.i(112274);
        a(getContext().getString(R.string.ggf), null, getContext().getString(R.string.ggb), null, getContext().getString(R.string.ggc), null, a.aG(getContext(), R.dimen.is));
        AppMethodBeat.o(112274);
    }

    private static void f(Object obj, View view) {
        AppMethodBeat.i(258247);
        if ((obj instanceof JSONObject) && view != null) {
            int optInt = ((JSONObject) obj).optInt("businessType");
            n nVar = n.UWX;
            if (n.RO((long) optInt)) {
                view.setVisibility(0);
                n nVar2 = n.UWX;
                n.RP((long) optInt);
                AppMethodBeat.o(258247);
                return;
            }
            view.setVisibility(8);
        }
        AppMethodBeat.o(258247);
    }

    private void a(String str, Object obj, String str2, Object obj2, String str3, Object obj3, int i2) {
        AppMethodBeat.i(112275);
        Log.i("MicroMsg.FTS.FTSMainUIEducationLayout", "addCellLayout %s %s %s", str, str2, str3);
        if (!Util.isNullOrNil(str)) {
            LinearLayout linearLayout = (LinearLayout) inflate(getContext(), R.layout.anm, null);
            View findViewById = linearLayout.findViewById(R.id.jtp);
            TextView textView = (TextView) linearLayout.findViewById(R.id.il2);
            textView.setText(str);
            findViewById.setTag(obj);
            findViewById.setTag(R.id.iwy, textView);
            findViewById.setTag(R.id.jzw, Boolean.TRUE);
            View findViewById2 = linearLayout.findViewById(R.id.k1x);
            findViewById.setTag(R.id.gy4, findViewById2);
            f(obj, findViewById2);
            findViewById.setVisibility(0);
            textView.setVisibility(0);
            findViewById.setOnClickListener(this.xcf);
            findViewById.setClickable(this.xeV);
            this.xeT.put(Integer.valueOf(com.tencent.mm.plugin.fts.ui.n.a((JSONObject) obj, str, getContext())), textView);
            dq(obj);
            if (!Util.isNullOrNil(str2)) {
                View findViewById3 = linearLayout.findViewById(R.id.jtq);
                TextView textView2 = (TextView) linearLayout.findViewById(R.id.il3);
                textView2.setText(str2);
                textView2.setVisibility(0);
                findViewById3.setTag(obj2);
                findViewById3.setTag(R.id.iwy, textView2);
                findViewById3.setTag(R.id.jzw, Boolean.TRUE);
                View findViewById4 = linearLayout.findViewById(R.id.k1y);
                findViewById3.setTag(R.id.gy4, findViewById4);
                f(obj2, findViewById4);
                findViewById3.setVisibility(0);
                findViewById3.setOnClickListener(this.xcf);
                findViewById3.setClickable(this.xeV);
                View findViewById5 = linearLayout.findViewById(R.id.bs_);
                findViewById5.getLayoutParams().height = i2;
                findViewById5.setVisibility(0);
                this.xeT.put(Integer.valueOf(com.tencent.mm.plugin.fts.ui.n.a((JSONObject) obj2, str2, getContext())), textView2);
                dq(obj2);
                if (!Util.isNullOrNil(str3)) {
                    View findViewById6 = linearLayout.findViewById(R.id.jtr);
                    TextView textView3 = (TextView) linearLayout.findViewById(R.id.il4);
                    textView3.setText(str3);
                    textView3.setVisibility(0);
                    findViewById6.setTag(obj3);
                    findViewById6.setTag(R.id.iwy, textView3);
                    findViewById6.setTag(R.id.jzw, Boolean.TRUE);
                    View findViewById7 = linearLayout.findViewById(R.id.k1z);
                    findViewById6.setTag(R.id.gy4, findViewById7);
                    f(obj3, findViewById7);
                    findViewById6.setVisibility(0);
                    findViewById6.setOnClickListener(this.xcf);
                    findViewById6.setClickable(this.xeV);
                    View findViewById8 = linearLayout.findViewById(R.id.bsa);
                    findViewById8.getLayoutParams().height = i2;
                    findViewById8.setVisibility(0);
                    this.xeT.put(Integer.valueOf(com.tencent.mm.plugin.fts.ui.n.a((JSONObject) obj3, str3, getContext())), textView3);
                    dq(obj3);
                }
            }
            this.xeS.add(linearLayout);
            addView(linearLayout);
        }
        AppMethodBeat.o(112275);
    }

    private void dq(Object obj) {
        AppMethodBeat.i(112276);
        if (obj != null && (obj instanceof JSONObject)) {
            String optString = ((JSONObject) obj).optString("businessType");
            if (!Util.isNullOrNil(optString)) {
                this.xeU = this.xeU == null ? "" : this.xeU;
                if (this.xeU.length() > 0) {
                    this.xeU += "|";
                }
                this.xeU += optString;
            }
        }
        AppMethodBeat.o(112276);
    }

    public String getVertBizTypes() {
        return this.xeU == null ? "" : this.xeU;
    }

    private void a(x.a aVar) {
        AppMethodBeat.i(258248);
        LinearLayout linearLayout = (LinearLayout) inflate(getContext(), R.layout.anp, null);
        ((TextView) linearLayout.findViewById(R.id.ir3)).setText(aVar.dQx);
        ImageView[] imageViewArr = {(ImageView) linearLayout.findViewById(R.id.n2), (ImageView) linearLayout.findViewById(R.id.n3), (ImageView) linearLayout.findViewById(R.id.n4), (ImageView) linearLayout.findViewById(R.id.n5)};
        ImageView imageView = (ImageView) linearLayout.findViewById(R.id.fki);
        int i2 = 0;
        while (i2 < aVar.iHf.size() && i2 < 4) {
            x.b bVar = aVar.iHf.get(i2);
            c.a aVar2 = new c.a();
            aVar2.jbq = R.raw.default_avatar;
            aVar2.iaT = true;
            q.bcV().a(bVar.kVZ, imageViewArr[i2], aVar2.bdv());
            imageViewArr[i2].setVisibility(0);
            imageViewArr[i2].setTag(bVar);
            if (this.xeZ != null) {
                imageViewArr[i2].setOnClickListener(this.xeZ);
            }
            i2++;
        }
        if (aVar.iHf.size() > 0) {
            imageView.setVisibility(0);
            imageView.setTag("more-click");
            imageView.setOnClickListener(this.xeZ);
        }
        addView(linearLayout);
        this.xeS.add(linearLayout);
        AppMethodBeat.o(258248);
    }

    public void setOnCellClickListener(View.OnClickListener onClickListener) {
        this.xcf = onClickListener;
    }

    public void setOnHotwordClickListener(View.OnClickListener onClickListener) {
        this.xeY = onClickListener;
    }

    public void setOnWxAppClickListener(View.OnClickListener onClickListener) {
        this.xeZ = onClickListener;
    }

    public void setSelected(int i2) {
        AppMethodBeat.i(112277);
        for (Map.Entry<Integer, TextView> entry : this.xeT.entrySet()) {
            if (entry.getKey().intValue() == i2) {
                entry.getValue().setTextColor(Color.parseColor("#B5B5B5"));
            } else {
                entry.getValue().setTextColor(getContext().getResources().getColor(R.color.afp));
            }
        }
        AppMethodBeat.o(112277);
    }

    public void setCellClickable(boolean z) {
        this.xeV = z;
    }

    public final void updateView() {
        int aG;
        boolean z;
        AppMethodBeat.i(112270);
        for (View view : this.xeS) {
            removeView(view);
        }
        this.xeS.clear();
        this.xeT.clear();
        this.xeU = "";
        try {
            JSONObject aXe = ak.aXe("educationTab");
            if (aXe == null) {
                z = false;
            } else {
                aXe.optString("title");
                JSONArray optJSONArray = aXe.optJSONArray("items");
                if (optJSONArray == null) {
                    z = false;
                } else {
                    if (LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()).equalsIgnoreCase(LocaleUtil.ENGLISH)) {
                        aG = a.aG(getContext(), R.dimen.q);
                    } else {
                        aG = a.aG(getContext(), R.dimen.is);
                    }
                    Object obj = null;
                    Object obj2 = null;
                    String str = null;
                    String str2 = null;
                    for (int i2 = 0; i2 < Math.min(optJSONArray.length(), 9); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (i2 % 3 == 0) {
                            str2 = optJSONObject.optString("hotword");
                            obj2 = optJSONObject;
                        } else if (i2 % 3 == 1) {
                            str = optJSONObject.optString("hotword");
                            obj = optJSONObject;
                        } else {
                            a(str2, obj2, str, obj, optJSONObject.optString("hotword"), optJSONObject, aG);
                            obj = null;
                            obj2 = null;
                            str = null;
                            str2 = null;
                        }
                    }
                    if (!(str2 == null || obj2 == null)) {
                        a(str2, obj2, str, obj, null, null, aG);
                    }
                    if (!this.UWZ) {
                        this.UWZ = true;
                        if (optJSONArray != null) {
                            StringBuilder sb = new StringBuilder();
                            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i3);
                                if (optJSONObject2 != null) {
                                    int optInt = optJSONObject2.optInt("businessType");
                                    String str3 = "";
                                    n nVar = n.UWX;
                                    if (n.RO((long) optInt)) {
                                        n nVar2 = n.UWX;
                                        str3 = n.hVM();
                                    }
                                    if (sb.length() > 0) {
                                        sb.append(";");
                                    }
                                    sb.append(optInt);
                                    sb.append("#").append(str3);
                                }
                            }
                            ar.jU(e.dOy(), sb.toString());
                        }
                    }
                    z = true;
                }
            }
            if (!z) {
                dPK();
            }
        } catch (Exception e2) {
            dPK();
        }
        try {
            if (this.xeW) {
                String optString = ak.aXe("educationHotword").optJSONArray("items").optJSONObject(0).optString("hotword");
                if (!Util.isNullOrNil(optString)) {
                    LinearLayout linearLayout = (LinearLayout) inflate(getContext(), R.layout.ano, null);
                    ((TextView) linearLayout.findViewById(R.id.dq6)).setText(optString);
                    linearLayout.setOnClickListener(this.xeY);
                    linearLayout.setTag(optString);
                    addView(linearLayout);
                    this.xeS.add(linearLayout);
                }
            }
        } catch (Exception e3) {
        }
        if (this.xeX) {
            x.a byv = ((x) g.af(x.class)).byv();
            if (byv.iHf != null && byv.iHf.size() > 0) {
                a(byv);
                String str4 = "";
                Iterator<x.b> it = byv.iHf.iterator();
                while (it.hasNext()) {
                    str4 = str4 + it.next().username + ";";
                }
                h.INSTANCE.a(14630, Long.valueOf(e.wVm), byv.dQx, str4, Integer.valueOf(byv.nMt), Long.valueOf(System.currentTimeMillis() / 1000));
            }
        }
        AppMethodBeat.o(112270);
    }
}
