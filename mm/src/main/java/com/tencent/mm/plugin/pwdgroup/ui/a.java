package com.tencent.mm.plugin.pwdgroup.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.pwdgroup.b;
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;

public final class a extends BaseAdapter {
    private Animation Bpi;
    private Animation Bpj;
    private HashMap<String, Boolean> Bpk = new HashMap<>();
    private Context mContext;
    private LinkedList<amg> rld = new LinkedList<>();
    private Animation ywd;

    public a(Context context) {
        AppMethodBeat.i(27672);
        this.mContext = context;
        this.ywd = AnimationUtils.loadAnimation(this.mContext, R.anim.n);
        this.Bpj = AnimationUtils.loadAnimation(this.mContext, R.anim.n);
        this.Bpi = AnimationUtils.loadAnimation(this.mContext, R.anim.o);
        this.ywd.setInterpolator(new AccelerateDecelerateInterpolator());
        this.Bpj.setInterpolator(new AccelerateInterpolator());
        this.Bpi.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ywd.setDuration(300);
        this.Bpj.setDuration(1000);
        this.Bpi.setDuration(1000);
        AppMethodBeat.o(27672);
    }

    public final void setData(LinkedList<amg> linkedList) {
        AppMethodBeat.i(27673);
        this.rld = linkedList;
        if (this.rld != null && this.rld.size() > 0) {
            int size = this.rld.size();
            for (int i2 = 0; i2 < size; i2++) {
                String a2 = a(this.rld.get(i2));
                if (!this.Bpk.containsKey(a2)) {
                    this.Bpk.put(a2, Boolean.FALSE);
                }
            }
        }
        notifyDataSetChanged();
        AppMethodBeat.o(27673);
    }

    public final int getCount() {
        AppMethodBeat.i(27674);
        if (this.rld == null) {
            AppMethodBeat.o(27674);
            return 1;
        }
        int size = this.rld.size() + 1;
        AppMethodBeat.o(27674);
        return size;
    }

    public final Object getItem(int i2) {
        AppMethodBeat.i(27675);
        if (this.rld == null) {
            AppMethodBeat.o(27675);
            return null;
        } else if (i2 >= this.rld.size()) {
            AppMethodBeat.o(27675);
            return null;
        } else {
            amg amg = this.rld.get(i2);
            AppMethodBeat.o(27675);
            return amg;
        }
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final View getView(int i2, final View view, ViewGroup viewGroup) {
        C1607a aVar;
        AppMethodBeat.i(27676);
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.a6t, (ViewGroup) null);
            C1607a aVar2 = new C1607a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (C1607a) view.getTag();
        }
        amg amg = (amg) getItem(i2);
        if (amg != null) {
            if (Util.isNullOrNil(amg.oUJ)) {
                aVar.hbb.setText(amg.UserName);
            } else {
                aVar.hbb.setText(amg.oUJ);
            }
            if (!Util.isNullOrNil(amg.UserName)) {
                b.a.c(aVar.kc, amg.UserName);
            } else {
                b.a.c(aVar.kc, amg.LuX);
            }
            String a2 = a(amg);
            view.clearAnimation();
            if (this.Bpk.containsKey(a2) && !this.Bpk.get(a2).booleanValue()) {
                view.startAnimation(this.ywd);
                this.Bpk.put(a2, Boolean.TRUE);
            }
        }
        if (i2 + 1 == getCount()) {
            aVar.hbb.setText("");
            aVar.kc.setImageResource(R.drawable.bw3);
            if (view != null) {
                this.Bpj.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.plugin.pwdgroup.ui.a.AnonymousClass1 */

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(27669);
                        view.startAnimation(a.this.Bpi);
                        AppMethodBeat.o(27669);
                    }
                });
                this.Bpi.setAnimationListener(new Animation.AnimationListener() {
                    /* class com.tencent.mm.plugin.pwdgroup.ui.a.AnonymousClass2 */

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(27670);
                        view.startAnimation(a.this.Bpj);
                        AppMethodBeat.o(27670);
                    }
                });
                view.startAnimation(this.Bpj);
            }
        }
        AppMethodBeat.o(27676);
        return view;
    }

    private static String a(amg amg) {
        AppMethodBeat.i(27677);
        if (amg == null) {
            AppMethodBeat.o(27677);
            return "";
        } else if (Util.isNullOrNil(amg.UserName)) {
            String str = amg.LuX;
            AppMethodBeat.o(27677);
            return str;
        } else {
            String str2 = amg.UserName;
            AppMethodBeat.o(27677);
            return str2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.pwdgroup.ui.a$a  reason: collision with other inner class name */
    class C1607a {
        TextView hbb;
        ImageView kc;

        public C1607a(View view) {
            AppMethodBeat.i(27671);
            this.kc = (ImageView) view.findViewById(R.id.caf);
            this.hbb = (TextView) view.findViewById(R.id.cao);
            AppMethodBeat.o(27671);
        }
    }
}
