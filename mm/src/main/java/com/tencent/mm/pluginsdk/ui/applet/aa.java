package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.b.o;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.d;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class aa implements i {
    private LinkedList<Integer> Bym;
    TextView BzK;
    private String CAZ;
    private String EQM;
    private LinkedList<String> Keb;
    boolean Kef = true;
    a Kgf;
    LinkedList<String> Kgg;
    public Map<String, Integer> Kgh;
    private boolean Kgi = true;
    private p Kgj;
    private boolean Kgk = false;
    public String chatroomName;
    public String content = "";
    Context context;
    View kdm;
    d kdo = null;
    EditText nBD;
    q tipDialog;
    String wHV;

    public interface a {
        /* renamed from: do  reason: not valid java name */
        void m36do(boolean z);
    }

    public aa(Context context2, a aVar) {
        AppMethodBeat.i(152244);
        this.context = context2;
        this.Kgf = aVar;
        AppMethodBeat.o(152244);
    }

    public final void mw(String str, String str2) {
        this.CAZ = str;
        this.EQM = str2;
    }

    private void onStart() {
        AppMethodBeat.i(152245);
        g.aAg().hqi.a(30, this);
        g.aAg().hqi.a(com.tencent.mm.plugin.appbrand.jsapi.o.b.d.CTRL_INDEX, this);
        AppMethodBeat.o(152245);
    }

    /* access modifiers changed from: package-private */
    public final void onStop() {
        AppMethodBeat.i(152246);
        g.aAg().hqi.b(30, this);
        g.aAg().hqi.b(com.tencent.mm.plugin.appbrand.jsapi.o.b.d.CTRL_INDEX, this);
        if (this.kdo != null) {
            this.kdo.dismiss();
            this.kdo = null;
        }
        AppMethodBeat.o(152246);
    }

    public final void gpI() {
        AppMethodBeat.i(152247);
        if (this.Kgj != null) {
            g.azz().a(this.Kgj);
        }
        AppMethodBeat.o(152247);
    }

    public final void a(LinkedList<String> linkedList, LinkedList<Integer> linkedList2, LinkedList<String> linkedList3) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(152248);
        Assert.assertTrue(linkedList.size() > 0);
        if (linkedList2.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        onStart();
        this.Kgg = linkedList;
        this.Bym = linkedList2;
        this.Keb = linkedList3;
        this.kdm = View.inflate(this.context, R.layout.bqa, null);
        Object[] objArr = new Object[3];
        if (this.wHV == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        objArr[1] = Integer.valueOf(this.wHV == null ? 0 : this.wHV.length());
        objArr[2] = this.wHV;
        Log.i("MicroMsg.SendVerifyRequest", "verifyTip is null: %b, length : %d, value : [%s]", objArr);
        if (!Util.isNullOrNil(this.wHV)) {
            ((TextView) this.kdm.findViewById(R.id.hku)).setText(this.wHV);
        }
        this.nBD = (EditText) this.kdm.findViewById(R.id.hkt);
        this.BzK = (TextView) this.kdm.findViewById(R.id.joi);
        this.BzK.setVisibility(0);
        this.nBD.setText((CharSequence) null);
        this.BzK.setText("50");
        this.nBD.setFilters(l.KvQ);
        this.nBD.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.pluginsdk.ui.applet.aa.AnonymousClass1 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(152237);
                int length = 50 - editable.length();
                if (length < 0) {
                    length = 0;
                }
                if (aa.this.BzK != null) {
                    aa.this.BzK.setText(String.valueOf(length));
                }
                AppMethodBeat.o(152237);
            }
        });
        this.kdo = h.a(this.context, this.context.getString(R.string.gks), this.kdm, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.applet.aa.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(152239);
                if (aa.this.kdo != null) {
                    aa.this.kdo.dismiss();
                    aa.this.kdo = null;
                }
                new MTimerHandler(new MTimerHandler.CallBack() {
                    /* class com.tencent.mm.pluginsdk.ui.applet.aa.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                    public final boolean onTimerExpired() {
                        AppMethodBeat.i(152238);
                        if (aa.this.kdm != null) {
                            aa aaVar = aa.this;
                            String trim = aa.this.nBD.getText().toString().trim();
                            Context context = aaVar.context;
                            aaVar.context.getString(R.string.zb);
                            aaVar.tipDialog = h.a(context, aaVar.context.getString(R.string.gko), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.pluginsdk.ui.applet.aa.AnonymousClass5 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(152242);
                                    aa.this.onStop();
                                    if (aa.this.Kgf != null) {
                                        aa.this.Kgf.m36do(false);
                                    }
                                    AppMethodBeat.o(152242);
                                }
                            });
                            aaVar.content = trim;
                            if (aaVar.Kgg.size() != 1 || !as.bjp(aaVar.Kgg.getFirst())) {
                                aaVar.gpf();
                            } else {
                                aaVar.gpJ();
                            }
                        }
                        AppMethodBeat.o(152238);
                        return false;
                    }
                }, false).startTimer(500);
                AppMethodBeat.o(152239);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.pluginsdk.ui.applet.aa.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(152240);
                if (aa.this.kdo != null) {
                    aa.this.kdo.dismiss();
                    aa.this.kdo = null;
                }
                aa.this.onStop();
                if (aa.this.Kgf != null) {
                    aa.this.Kgf.m36do(false);
                }
                AppMethodBeat.o(152240);
            }
        });
        if (this.kdo == null) {
            onStop();
        }
        this.nBD.post(new Runnable() {
            /* class com.tencent.mm.pluginsdk.ui.applet.aa.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(152241);
                if (aa.this.context instanceof MMActivity) {
                    ((MMActivity) aa.this.context).showVKB();
                }
                AppMethodBeat.o(152241);
            }
        });
        AppMethodBeat.o(152248);
    }

    public final void z(List<String> list, List<Integer> list2) {
        AppMethodBeat.i(152249);
        this.Kgi = false;
        onStart();
        this.Kgg = new LinkedList<>(list);
        this.Bym = new LinkedList<>(list2);
        if (list.size() != 1 || !as.bjp(this.Kgg.getFirst())) {
            gpf();
            AppMethodBeat.o(152249);
            return;
        }
        gpJ();
        AppMethodBeat.o(152249);
    }

    /* access modifiers changed from: package-private */
    public final void gpf() {
        AppMethodBeat.i(152250);
        this.Kgj = new p(this.Kgg, this.Bym, this.content, "", this.Kgh, this.chatroomName);
        this.Kgj.zJ(this.Kef);
        this.Kgj.mw(this.CAZ, this.EQM);
        g.aAg().hqi.a(this.Kgj, 0);
        AppMethodBeat.o(152250);
    }

    /* access modifiers changed from: package-private */
    public final void gpJ() {
        AppMethodBeat.i(152251);
        if (this.Keb == null || this.Keb.isEmpty()) {
            this.Kgk = true;
            g.aAg().hqi.a(881, this);
            g.aAg().hqi.a(new com.tencent.mm.openim.b.h(this.Kgg.getFirst(), "", ""), 0);
            AppMethodBeat.o(152251);
            return;
        }
        g.aAg().hqi.a(new o(this.Kgg.getFirst(), this.content, this.Keb.getFirst(), 0), 0);
        AppMethodBeat.o(152251);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(152252);
        if (qVar.getType() == 881) {
            g.aAg().hqi.b(881, this);
            if (i2 != 0 || i3 != 0) {
                Toast.makeText(this.context, this.context.getString(R.string.gkm), 1).show();
            } else if (this.Kgk) {
                g.aAg().hqi.a(new o(this.Kgg.getFirst(), this.content, ((com.tencent.mm.openim.b.h) qVar).jHb.KHz, 0), 0);
            }
            this.Kgk = false;
            AppMethodBeat.o(152252);
        } else if (qVar.getType() != 30 && qVar.getType() != 243) {
            Log.w("MicroMsg.SendVerifyRequest", "not expected scene,  type = " + qVar.getType());
            AppMethodBeat.o(152252);
        } else if (!(qVar instanceof p) || ((p) qVar).dKy == 2) {
            Log.d("MicroMsg.SendVerifyRequest", "onSceneEnd, errType = " + i2 + ", errCode = " + i3);
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            onStop();
            if (i2 == 0 && i3 == 0) {
                if (this.Kgi) {
                    h.cD(this.context, this.context.getString(R.string.gkn));
                }
                if (this.Kgf != null) {
                    this.Kgf.m36do(true);
                    AppMethodBeat.o(152252);
                    return;
                }
            } else {
                if (i2 == 4 && i3 == -34) {
                    str = this.context.getString(R.string.ddu);
                } else if (i2 == 4 && i3 == -94) {
                    str = this.context.getString(R.string.ddx);
                } else if (!(i2 == 4 && i3 == -24 && !Util.isNullOrNil(str))) {
                    if (i3 == -160) {
                        if (!Util.isNullOrNil(str)) {
                            h.c(this.context, str, "", this.context.getResources().getString(R.string.t9), this.context.getResources().getString(R.string.sz), new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.pluginsdk.ui.applet.aa.AnonymousClass6 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(152243);
                                    aa.this.Kef = false;
                                    aa.this.gpf();
                                    AppMethodBeat.o(152243);
                                }
                            }, null);
                            str = null;
                        } else {
                            str = null;
                        }
                    } else if (i2 != 4 || Util.isNullOrNil(str)) {
                        str = this.context.getString(R.string.gkm);
                    }
                }
                if (this.Kgi && !Util.isNullOrNil(str)) {
                    Toast.makeText(this.context, str, 1).show();
                }
                if (this.Kgf != null) {
                    this.Kgf.m36do(false);
                }
            }
            AppMethodBeat.o(152252);
        } else {
            Log.e("MicroMsg.SendVerifyRequest", "not opcode sendrequest!");
            AppMethodBeat.o(152252);
        }
    }
}
