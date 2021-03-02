package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.model.e.g;
import com.tencent.mm.plugin.ipcall.model.f.e;
import com.tencent.mm.plugin.ipcall.model.g.b;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.o;
import com.tencent.mm.pluginsdk.ui.applet.y;
import com.tencent.mm.protocal.protobuf.byf;
import com.tencent.mm.protocal.protobuf.ewo;
import com.tencent.mm.protocal.protobuf.ewp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.o.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class IPCallShareCouponCardUI extends MMActivity implements i, a.AbstractC2123a, a.b {
    private ProgressDialog gtM = null;
    private String mDesc = null;
    private int mFrom = 0;
    private String mTitle = null;
    private String mWording = null;
    private View nNt;
    private ProgressDialog vIA = null;
    private ProgressDialog yuB = null;
    private TextView yxE;
    private TextView yxF;
    private TextView yxG;
    private TextView yxH;
    private Button yxI;
    private ImageView yxJ;
    private a yxK = new a();
    private i yxL = null;
    private ImageView yxM = null;
    private ProgressBar yxN = null;
    private e yxO = new e();
    private String yxP = null;
    private String yxQ = null;
    private String yxR = null;
    private String yxS = null;
    private String yxT = null;
    private String yxU = null;
    private String yxV = null;
    private String yxW = null;
    private ewp yxX = null;
    private String yxY = null;
    private View yxZ;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public IPCallShareCouponCardUI() {
        AppMethodBeat.i(25917);
        AppMethodBeat.o(25917);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25918);
        super.onCreate(bundle);
        setMMTitle(R.string.e9h);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25903);
                IPCallShareCouponCardUI.this.finish();
                AppMethodBeat.o(25903);
                return true;
            }
        });
        this.nNt = findViewById(R.id.e95);
        this.yxE = (TextView) findViewById(R.id.bgs);
        this.yxF = (TextView) findViewById(R.id.bkh);
        this.yxG = (TextView) findViewById(R.id.bgr);
        this.yxH = (TextView) findViewById(R.id.bgt);
        this.yxI = (Button) findViewById(R.id.hp6);
        this.yxJ = (ImageView) findViewById(R.id.dod);
        this.nNt.setVisibility(8);
        a.b.a(this.yxJ, z.aTY(), 0.5f, false);
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.yuB = h.a((Context) context, getString(R.string.e6r), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.AnonymousClass9 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(25911);
                try {
                    IPCallShareCouponCardUI.this.finish();
                    AppMethodBeat.o(25911);
                } catch (Exception e2) {
                    Log.e("MicroMsg.IPCallShareCouponCardUI", "loadFromSystemAddressBook error: %s", e2.getMessage());
                    AppMethodBeat.o(25911);
                }
            }
        });
        b.eaU().qy(false);
        this.mFrom = getIntent().getIntExtra("IPCallShareCouponCardUI_KFrom", 0);
        bg.azz().a(CdnLogic.kAppTypeFestivalImage, this);
        bg.azz().a(1804, this);
        AppMethodBeat.o(25918);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(25919);
        super.onResume();
        AppMethodBeat.o(25919);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(25920);
        super.onDestroy();
        bg.azz().b(CdnLogic.kAppTypeFestivalImage, this);
        bg.azz().b(1804, this);
        AppMethodBeat.o(25920);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.awl;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        String str2;
        AppMethodBeat.i(25921);
        if (qVar instanceof g) {
            if (i2 == 0 && i3 == 0) {
                this.nNt.setVisibility(0);
                byf ebR = c.ebR();
                if (ebR != null) {
                    this.yxP = ebR.MdG;
                    this.mDesc = ebR.Desc;
                    this.yxQ = ebR.MdH;
                    this.mTitle = ebR.Title;
                    this.mWording = ebR.xJH;
                    this.yxR = ebR.MdI;
                    this.yxT = ebR.MdJ;
                    this.yxU = ebR.MdK;
                    this.yxV = ebR.MdL;
                    this.yxW = ebR.MdN;
                    this.yxX = ebR.MdM;
                    this.yxY = ebR.MdO;
                }
                this.yxE.setText(this.yxW);
                this.yxF.setText(String.format(getContext().getString(R.string.e9a), this.yxP));
                this.yxI.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.AnonymousClass11 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(25913);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponCardUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        IPCallShareCouponCardUI.a(IPCallShareCouponCardUI.this);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponCardUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(25913);
                    }
                });
                this.yxG.setText(String.format(getString(R.string.e9c), this.yxW));
                TextView textView = this.yxH;
                String format = String.format(getString(R.string.e9b), this.yxW);
                final String string = getString(R.string.e9g);
                if (Util.isNullOrNil(string)) {
                    textView.setText(format);
                } else {
                    String string2 = getString(R.string.e9j);
                    TextPaint paint = textView.getPaint();
                    float measureText = paint.measureText(format);
                    float measureText2 = paint.measureText(string2);
                    int jn = com.tencent.mm.cb.a.jn(getContext()) - (((LinearLayout.LayoutParams) textView.getLayoutParams()).rightMargin + ((LinearLayout.LayoutParams) textView.getLayoutParams()).leftMargin);
                    int ceil = (int) Math.ceil((double) (measureText / ((float) jn)));
                    int ceil2 = (int) Math.ceil((double) ((measureText + measureText2) / ((float) jn)));
                    if (ceil == 0) {
                        ceil = 1;
                    }
                    if (ceil2 > ceil) {
                        str2 = "\n".concat(String.valueOf(string2));
                    } else {
                        str2 = string2;
                    }
                    textView.setGravity(17);
                    Spannable newSpannable = Spannable.Factory.getInstance().newSpannable(format + str2);
                    newSpannable.setSpan(new ClickableSpan() {
                        /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.AnonymousClass6 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(25907);
                            ((TextView) view).setHighlightColor(IPCallShareCouponCardUI.this.getResources().getColor(R.color.ac_));
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13340, -1, -1, -1, -1, 1);
                            h.c(IPCallShareCouponCardUI.this.getContext(), string, IPCallShareCouponCardUI.this.getString(R.string.e9k), true).a(R.string.e64, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.AnonymousClass6.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                }
                            });
                            AppMethodBeat.o(25907);
                        }

                        public final void updateDrawState(TextPaint textPaint) {
                            AppMethodBeat.i(25908);
                            textPaint.setColor(IPCallShareCouponCardUI.this.getResources().getColor(R.color.x0));
                            textPaint.setUnderlineText(false);
                            AppMethodBeat.o(25908);
                        }
                    }, format.length(), str2.length() + format.length(), 33);
                    textView.setText(newSpannable);
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                if (this.yuB != null && this.yuB.isShowing()) {
                    this.yuB.dismiss();
                }
                AppMethodBeat.o(25921);
                return;
            } else if (this.yuB != null && this.yuB.isShowing()) {
                this.yuB.dismiss();
                h.d(getContext(), getString(R.string.e6p), getString(R.string.e6i), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.AnonymousClass10 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(25912);
                        IPCallShareCouponCardUI.this.finish();
                        AppMethodBeat.o(25912);
                    }
                });
                AppMethodBeat.o(25921);
                return;
            }
        } else if (qVar instanceof com.tencent.mm.modelmulti.h) {
            if (this.gtM != null) {
                this.gtM.dismiss();
                this.gtM = null;
            }
            if (com.tencent.mm.plugin.subapp.b.jRu.b(getContext(), i2, i3, str)) {
                AppMethodBeat.o(25921);
                return;
            } else if (i2 == 0 && i3 == 0) {
                h.cD(this, getResources().getString(R.string.b99));
                AppMethodBeat.o(25921);
                return;
            } else {
                h.n(getContext(), R.string.gkm, R.string.zb);
                AppMethodBeat.o(25921);
                return;
            }
        } else if (qVar instanceof com.tencent.mm.bc.a) {
            if (i2 != 0 || i3 != 0) {
                AppMethodBeat.o(25921);
                return;
            } else if (this.yxM != null) {
                if (this.yxN != null) {
                    this.yxN.setVisibility(8);
                }
                this.yxM.setImageBitmap(ebs());
            }
        }
        AppMethodBeat.o(25921);
    }

    public static void a(Context context, int i2, TextView textView, ImageView imageView) {
        AppMethodBeat.i(25922);
        String ak = ak(context, i2);
        if (ak != null) {
            textView.setText(ak);
        }
        int Pn = Pn(i2);
        if (Pn != -1) {
            imageView.setImageResource(Pn);
        }
        AppMethodBeat.o(25922);
    }

    public static String ak(Context context, int i2) {
        AppMethodBeat.i(25923);
        HashMap hashMap = new HashMap();
        hashMap.put(8, context.getString(R.string.e7i));
        hashMap.put(0, context.getString(R.string.j1s));
        hashMap.put(1, context.getString(R.string.e7n));
        hashMap.put(3, context.getString(R.string.e7j));
        hashMap.put(2, context.getString(R.string.e7m));
        hashMap.put(5, context.getString(R.string.e7o));
        hashMap.put(4, context.getString(R.string.e7p));
        hashMap.put(6, context.getString(R.string.e7l));
        hashMap.put(7, context.getString(R.string.e7k));
        if (hashMap.containsKey(Integer.valueOf(i2))) {
            String str = (String) hashMap.get(Integer.valueOf(i2));
            AppMethodBeat.o(25923);
            return str;
        }
        AppMethodBeat.o(25923);
        return null;
    }

    public static int Pn(int i2) {
        AppMethodBeat.i(25924);
        HashMap hashMap = new HashMap();
        hashMap.put(8, Integer.valueOf((int) R.raw.bottomsheet_copy));
        hashMap.put(0, Integer.valueOf((int) R.raw.bottomsheet_repost));
        hashMap.put(1, Integer.valueOf((int) R.raw.bottomsheet_moment));
        hashMap.put(3, Integer.valueOf((int) R.raw.bottomsheet_email));
        hashMap.put(2, Integer.valueOf((int) R.raw.bottomsheet_sms));
        hashMap.put(5, Integer.valueOf((int) R.raw.bottomsheet_twitter));
        hashMap.put(4, Integer.valueOf((int) R.raw.bottomsheet_whatsapp));
        hashMap.put(6, Integer.valueOf((int) R.raw.bottomsheet_facebook));
        hashMap.put(7, Integer.valueOf((int) R.raw.bottomsheet_messenger));
        if (hashMap.containsKey(Integer.valueOf(i2))) {
            int intValue = ((Integer) hashMap.get(Integer.valueOf(i2))).intValue();
            AppMethodBeat.o(25924);
            return intValue;
        }
        AppMethodBeat.o(25924);
        return -1;
    }

    private static boolean checkApkExist(Context context, String str) {
        AppMethodBeat.i(25925);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(25925);
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            AppMethodBeat.o(25925);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(25925);
            return false;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.o.a.b
    public final void a(a.c cVar) {
        AppMethodBeat.i(25926);
        if (this.vIA != null) {
            this.vIA.cancel();
        }
        switch (cVar) {
            case Finished:
                Po(R.string.hrs);
                AppMethodBeat.o(25926);
                return;
            case Canceled:
                AppMethodBeat.o(25926);
                return;
            case QAR:
                Po(R.string.hrr);
                break;
        }
        AppMethodBeat.o(25926);
    }

    private void Po(int i2) {
        AppMethodBeat.i(25927);
        h.a(getContext(), i2, (int) R.string.zb, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.AnonymousClass14 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.AnonymousClass15 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(25927);
    }

    @Override // com.tencent.mm.ui.o.a.AbstractC2123a
    public final void b(a.c cVar) {
    }

    private static Bitmap ebs() {
        AppMethodBeat.i(25928);
        byte[] aCo = aCo(z.aTY());
        if (aCo == null) {
            AppMethodBeat.o(25928);
            return null;
        }
        Bitmap decodeByteArray = BitmapUtil.decodeByteArray(aCo);
        AppMethodBeat.o(25928);
        return decodeByteArray;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063 A[SYNTHETIC, Splitter:B:18:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f A[SYNTHETIC, Splitter:B:24:0x006f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] aCo(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 128
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.aCo(java.lang.String):byte[]");
    }

    private void E(final int i2, final String str, String str2) {
        AppMethodBeat.i(25930);
        this.yxZ = View.inflate(getContext(), R.layout.vz, null);
        final EditText editText = (EditText) this.yxZ.findViewById(R.id.b_h);
        this.yxM = (ImageView) this.yxZ.findViewById(R.id.b_e);
        this.yxN = (ProgressBar) this.yxZ.findViewById(R.id.epo);
        editText.setText(str);
        Bitmap ebs = ebs();
        if (ebs == null) {
            String aTY = z.aTY();
            bg.aVF();
            bg.azz().a(new com.tencent.mm.bc.a(aTY, Util.nullAsNil((Integer) com.tencent.mm.model.c.azQ().get(66561, (Object) null))), 0);
            this.yxN.setVisibility(0);
        } else if (this.yxM != null) {
            this.yxM.setImageBitmap(ebs);
        }
        o.a(this.mController, str2, this.yxZ, getResources().getString(R.string.yq), new y.b() {
            /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.AnonymousClass5 */

            @Override // com.tencent.mm.pluginsdk.ui.applet.y.b
            public final void qB(boolean z) {
                String obj;
                AppMethodBeat.i(25906);
                if (z) {
                    if (editText == null) {
                        obj = str;
                    } else {
                        obj = editText.getText().toString();
                    }
                    final com.tencent.mm.modelmulti.h hVar = new com.tencent.mm.modelmulti.h(i2, obj);
                    IPCallShareCouponCardUI iPCallShareCouponCardUI = IPCallShareCouponCardUI.this;
                    IPCallShareCouponCardUI iPCallShareCouponCardUI2 = IPCallShareCouponCardUI.this;
                    IPCallShareCouponCardUI.this.getString(R.string.zb);
                    iPCallShareCouponCardUI.gtM = h.a((Context) iPCallShareCouponCardUI2, IPCallShareCouponCardUI.this.getString(R.string.ys), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.AnonymousClass5.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(25905);
                            bg.azz().a(hVar);
                            AppMethodBeat.o(25905);
                        }
                    });
                    bg.azz().a(hVar, 0);
                    AppMethodBeat.o(25906);
                    return;
                }
                AppMethodBeat.o(25906);
            }
        });
        AppMethodBeat.o(25930);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(25931);
        if (i2 == 1 && intent != null) {
            final String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!Util.isNullOrNil(stringExtra)) {
                o.a(getController(), this.mTitle, this.yxQ, this.mDesc, true, getResources().getString(R.string.yq), (y.a) new y.a() {
                    /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.AnonymousClass7 */

                    @Override // com.tencent.mm.pluginsdk.ui.applet.y.a
                    public final void a(boolean z, String str, int i2) {
                        AppMethodBeat.i(25909);
                        if (z) {
                            k.b bVar = new k.b();
                            bVar.title = IPCallShareCouponCardUI.this.mTitle;
                            bVar.url = IPCallShareCouponCardUI.this.yxR;
                            bVar.description = IPCallShareCouponCardUI.this.mDesc;
                            bVar.thumburl = IPCallShareCouponCardUI.this.yxQ;
                            bVar.type = 5;
                            m.a(bVar, (String) null, (String) null, stringExtra, "", (byte[]) null, (String) null);
                            if (!Util.isNullOrNil(str)) {
                                tw twVar = new tw();
                                twVar.eaq.dkV = stringExtra;
                                twVar.eaq.content = str;
                                twVar.eaq.type = ab.JG(stringExtra);
                                twVar.eaq.flags = 0;
                                EventCenter.instance.publish(twVar);
                            }
                            h.cD(IPCallShareCouponCardUI.this.getContext(), IPCallShareCouponCardUI.this.getResources().getString(R.string.z0));
                            AppMethodBeat.o(25909);
                            return;
                        }
                        AppMethodBeat.o(25909);
                    }
                });
            }
        }
        AppMethodBeat.o(25931);
    }

    static /* synthetic */ void a(IPCallShareCouponCardUI iPCallShareCouponCardUI) {
        AppMethodBeat.i(25932);
        iPCallShareCouponCardUI.yxO.start();
        iPCallShareCouponCardUI.yxO.yrX = (long) iPCallShareCouponCardUI.mFrom;
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 19, 1, true);
        if (iPCallShareCouponCardUI.yxX != null) {
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) iPCallShareCouponCardUI.getContext(), 0, true);
            eVar.o(iPCallShareCouponCardUI.getString(R.string.e9l), 17);
            eVar.HLX = new o.f() {
                /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.AnonymousClass12 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                    AppMethodBeat.i(25914);
                    Iterator it = IPCallShareCouponCardUI.a(IPCallShareCouponCardUI.this, IPCallShareCouponCardUI.this.yxX.Nui).iterator();
                    while (it.hasNext()) {
                        Integer num = (Integer) it.next();
                        String ak = IPCallShareCouponCardUI.ak(IPCallShareCouponCardUI.this.getContext(), num.intValue());
                        int Pn = IPCallShareCouponCardUI.Pn(num.intValue());
                        if (!(ak == null || Pn == -1)) {
                            mVar.b(num.intValue(), ak, Pn);
                        }
                    }
                    AppMethodBeat.o(25914);
                }
            };
            eVar.HLY = new o.g() {
                /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.AnonymousClass13 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(25915);
                    IPCallShareCouponCardUI.a(IPCallShareCouponCardUI.this, menuItem.getItemId());
                    AppMethodBeat.o(25915);
                }
            };
            eVar.dGm();
        }
        AppMethodBeat.o(25932);
    }

    static /* synthetic */ LinkedList a(IPCallShareCouponCardUI iPCallShareCouponCardUI, LinkedList linkedList) {
        boolean z;
        AppMethodBeat.i(25933);
        Log.i("MicroMsg.IPCallShareCouponCardUI", "CheckedShareList svr size =" + linkedList.size());
        LinkedList linkedList2 = new LinkedList();
        linkedList2.add(8);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ewo ewo = (ewo) it.next();
            AppCompatActivity context = iPCallShareCouponCardUI.getContext();
            int i2 = ewo.ID;
            if (i2 == 8 || i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5) {
                z = true;
            } else if (i2 == 4) {
                z = checkApkExist(context, "com.whatsapp");
            } else if (i2 == 6) {
                z = z.aUC();
            } else if (i2 == 7) {
                z = checkApkExist(context, "com.facebook.orca");
            } else {
                z = false;
            }
            if (z) {
                linkedList2.add(Integer.valueOf(ewo.ID));
            }
        }
        Log.i("MicroMsg.IPCallShareCouponCardUI", "CheckedShareList final size =" + linkedList2.size());
        AppMethodBeat.o(25933);
        return linkedList2;
    }

    static /* synthetic */ void a(IPCallShareCouponCardUI iPCallShareCouponCardUI, int i2) {
        AppMethodBeat.i(25934);
        String str = iPCallShareCouponCardUI.yxV + " " + iPCallShareCouponCardUI.yxY + String.format("&rt=%s", Integer.valueOf(i2));
        switch (i2) {
            case 0:
                Log.i("MicroMsg.IPCallShareCouponCardUI", "onShare2Friends>title:%s,onShare2Friends>url:%s,onShare2Friends>desc:%s,onShare2Friends>imgPath:%s", iPCallShareCouponCardUI.mTitle, iPCallShareCouponCardUI.yxR + String.format("&rt=%s", Integer.valueOf(i2)), iPCallShareCouponCardUI.mDesc, iPCallShareCouponCardUI.yxQ);
                iPCallShareCouponCardUI.yxO.yrY = 0;
                iPCallShareCouponCardUI.yxO.finish();
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 20, 1, true);
                Intent intent = new Intent();
                intent.putExtra("Select_Conv_Type", 259);
                intent.putExtra("select_is_ret", true);
                com.tencent.mm.br.c.c(iPCallShareCouponCardUI, ".ui.transmit.SelectConversationUI", intent, 1);
                break;
            case 1:
                String str2 = iPCallShareCouponCardUI.mTitle;
                String str3 = iPCallShareCouponCardUI.yxR + String.format("&rt=%s", Integer.valueOf(i2));
                String str4 = iPCallShareCouponCardUI.mDesc;
                String str5 = iPCallShareCouponCardUI.yxQ;
                Log.i("MicroMsg.IPCallShareCouponCardUI", "onShareSnsEvent>title:%s,onShareSnsEvent>url:%s,onShareSnsEvent>content:%s,onShareSnsEvent>content:%s", str2, str3, str4, str5);
                iPCallShareCouponCardUI.yxO.yrY = 1;
                iPCallShareCouponCardUI.yxO.finish();
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(257, 21, 1, true);
                Intent intent2 = new Intent();
                intent2.putExtra("Ksnsupload_type", 1);
                intent2.putExtra("need_result", false);
                intent2.putExtra("Ksnsupload_title", Util.nullAs(str2, ""));
                intent2.putExtra("Ksnsupload_imgurl", str5);
                intent2.putExtra("Ksnsupload_link", str3);
                String JX = ad.JX(WeChatBrands.Business.GROUP_WECHAT_OUT);
                ad.aVe().G(JX, true).l("prePublishId", WeChatBrands.Business.GROUP_WECHAT_OUT);
                intent2.putExtra("reportSessionId", JX);
                com.tencent.mm.br.c.b(iPCallShareCouponCardUI, "sns", ".ui.SnsUploadUI", intent2, 1);
                break;
            case 2:
                Intent intent3 = new Intent("android.intent.action.VIEW");
                intent3.putExtra("sms_body", str);
                intent3.setType("vnd.android-dir/mms-sms");
                if (!Util.isIntentAvailable(iPCallShareCouponCardUI, intent3)) {
                    Toast.makeText(iPCallShareCouponCardUI, (int) R.string.giz, 1).show();
                    break;
                } else {
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                    com.tencent.mm.hellhoundlib.a.a.a(iPCallShareCouponCardUI, bl.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponCardUI", "handleShareId", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    iPCallShareCouponCardUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(iPCallShareCouponCardUI, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponCardUI", "handleShareId", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    break;
                }
            case 3:
                Intent intent4 = new Intent("android.intent.action.SEND");
                intent4.putExtra("android.intent.extra.SUBJECT", String.format(iPCallShareCouponCardUI.getString(R.string.e9f), z.aUa()));
                intent4.putExtra("android.intent.extra.TEXT", str);
                intent4.setType("plain/text");
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(Intent.createChooser(intent4, iPCallShareCouponCardUI.getString(R.string.e46)));
                com.tencent.mm.hellhoundlib.a.a.a(iPCallShareCouponCardUI, bl2.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponCardUI", "handleShareId", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                iPCallShareCouponCardUI.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(iPCallShareCouponCardUI, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponCardUI", "handleShareId", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                break;
            case 4:
                try {
                    Intent intent5 = new Intent();
                    intent5.setAction("android.intent.action.SEND");
                    intent5.putExtra("android.intent.extra.TEXT", str);
                    intent5.setType("text/plain");
                    intent5.setPackage("com.whatsapp");
                    com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent5);
                    com.tencent.mm.hellhoundlib.a.a.a(iPCallShareCouponCardUI, bl3.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponCardUI", "handleShareId", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    iPCallShareCouponCardUI.startActivity((Intent) bl3.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(iPCallShareCouponCardUI, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponCardUI", "handleShareId", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    break;
                } catch (Exception e2) {
                    Log.e("MicroMsg.IPCallShareCouponCardUI", "go whatsapp error" + e2.getMessage());
                    break;
                }
            case 5:
                if (!iPCallShareCouponCardUI.yxK.gYx()) {
                    h.a(iPCallShareCouponCardUI.getContext(), (int) R.string.gvt, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.AnonymousClass16 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25916);
                            IPCallShareCouponCardUI iPCallShareCouponCardUI = IPCallShareCouponCardUI.this;
                            AppCompatActivity context = IPCallShareCouponCardUI.this.getContext();
                            IPCallShareCouponCardUI.this.getContext().getString(R.string.zb);
                            iPCallShareCouponCardUI.vIA = h.a((Context) context, IPCallShareCouponCardUI.this.getContext().getString(R.string.hrq), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.AnonymousClass16.AnonymousClass1 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                }
                            });
                            IPCallShareCouponCardUI.this.yxK.a(IPCallShareCouponCardUI.this, IPCallShareCouponCardUI.this.getContext());
                            AppMethodBeat.o(25916);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    break;
                } else {
                    iPCallShareCouponCardUI.E(16, str, iPCallShareCouponCardUI.getString(R.string.e48));
                    break;
                }
            case 6:
                if (!z.aUF()) {
                    h.a(iPCallShareCouponCardUI.getContext(), (int) R.string.gon, (int) R.string.zb, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(25904);
                            com.tencent.mm.br.c.b(IPCallShareCouponCardUI.this.getContext(), "account", ".ui.FacebookAuthUI", new Intent());
                            AppMethodBeat.o(25904);
                        }
                    }, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    break;
                } else {
                    iPCallShareCouponCardUI.E(8, str, iPCallShareCouponCardUI.getString(R.string.e43));
                    break;
                }
            case 7:
                try {
                    Intent intent6 = new Intent();
                    intent6.setAction("android.intent.action.SEND");
                    intent6.putExtra("android.intent.extra.TEXT", str);
                    intent6.setType("text/plain");
                    intent6.setPackage("com.facebook.orca");
                    com.tencent.mm.hellhoundlib.b.a bl4 = new com.tencent.mm.hellhoundlib.b.a().bl(intent6);
                    com.tencent.mm.hellhoundlib.a.a.a(iPCallShareCouponCardUI, bl4.axQ(), "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponCardUI", "handleShareId", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    iPCallShareCouponCardUI.startActivity((Intent) bl4.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(iPCallShareCouponCardUI, "com/tencent/mm/plugin/ipcall/ui/IPCallShareCouponCardUI", "handleShareId", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    break;
                } catch (Exception e3) {
                    Log.e("MicroMsg.IPCallShareCouponCardUI", "go facebook msger error" + e3.getMessage());
                    break;
                }
            case 8:
                c.aCE(str);
                Toast.makeText(iPCallShareCouponCardUI, (int) R.string.e7h, 0).show();
                break;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13340, -1, 1, Integer.valueOf(i2), -1, -1);
        AppMethodBeat.o(25934);
    }
}
