package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.p;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.s;
import java.util.LinkedList;

public final class n extends s<o> {
    private static w xUs;
    private int dCm = 0;
    private int gAZ = 0;
    private Context mContext;
    private int qdp = 15;
    private int xGR = 0;
    private long xUA;
    private p xUB;
    private f<String, Bitmap> xUC;
    private View.OnClickListener xUt;
    private View.OnClickListener xUu;
    private v xUv;
    private v xUw;
    private long xUx = 0;
    private int xUy = 0;
    int xUz = 0;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* bridge */ /* synthetic */ o a(o oVar, Cursor cursor) {
        AppMethodBeat.i(42276);
        o a2 = a(oVar, cursor);
        AppMethodBeat.o(42276);
        return a2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ o getItem(int i2) {
        AppMethodBeat.i(42275);
        o Oy = Oy(i2);
        AppMethodBeat.o(42275);
        return Oy;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(Context context, o oVar, int i2, long j2) {
        super(context, oVar);
        int i3;
        int i4 = 0;
        AppMethodBeat.i(42259);
        this.mContext = context;
        this.xGR = i2;
        this.xUA = j2;
        Cursor rawQuery = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().rawQuery("select count(*) from GameRawMessage where " + com.tencent.mm.plugin.game.model.s.D(2, 5, 6, 10, 11, 100) + " and showInMsgList = 1 and isHidden = 0", new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i3 = rawQuery.getInt(0);
            } else {
                i3 = 0;
            }
            rawQuery.close();
            i4 = i3;
        }
        this.gAZ = i4;
        this.dCm = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().dVz();
        xUs = new w();
        this.xUt = new o(context, i2);
        this.xUu = new p(context, i2);
        this.xUv = new v(context);
        this.xUv.gL(i2, 1);
        this.xUw = new v(context);
        this.xUw.gL(i2, 2);
        this.xUB = new p(context, this.xGR);
        this.xUy = com.tencent.mm.cb.a.E(this.mContext, ((c.getScreenWidth(this.mContext) - (this.mContext.getResources().getDimensionPixelSize(R.dimen.r) * 2)) - this.mContext.getResources().getDimensionPixelSize(R.dimen.gp)) - this.mContext.getResources().getDimensionPixelSize(R.dimen.ib)) / 34;
        this.xUC = new b(30, getClass());
        AppMethodBeat.o(42259);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        String str;
        boolean z;
        String str2;
        AppMethodBeat.i(42260);
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(this.context, R.layout.aru, null);
            aVar2.xUF = (ImageView) view.findViewById(R.id.dtx);
            aVar2.xUE = (LinearLayout) view.findViewById(R.id.fm5);
            aVar2.xUG = (LinearLayout) view.findViewById(R.id.fmb);
            aVar2.gvw = (TextView) view.findViewById(R.id.fzg);
            aVar2.xUH = (ImageView) view.findViewById(R.id.z3);
            aVar2.nnM = (TextView) view.findViewById(R.id.ipe);
            aVar2.xUI = (TextView) view.findViewById(R.id.fmf);
            aVar2.xUJ = (LinearLayout) view.findViewById(R.id.fmw);
            aVar2.xUK = (TextView) view.findViewById(R.id.fmy);
            aVar2.xUL = (ImageView) view.findViewById(R.id.fmx);
            aVar2.xUM = (ImageView) view.findViewById(R.id.fmj);
            aVar2.xUN = (TextView) view.findViewById(R.id.fn5);
            aVar2.xUO = (TextView) view.findViewById(R.id.fn1);
            aVar2.xUQ = (GameMessageListContainerView) view.findViewById(R.id.fn9);
            aVar2.xUP = (LinearLayout) view.findViewById(R.id.fme);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        o Oy = Oy(i2);
        if (Oy == null || !Oy.xGb) {
            if (Oy != null) {
                Oy.dVl();
                if (!Oy.xEs) {
                    Oy.xEs = true;
                    int i3 = i2 + 1001;
                    if (this.dCm > 0 && i2 > this.dCm) {
                        i3 = i2 - 1;
                    }
                    com.tencent.mm.game.report.f.a(this.mContext, 13, 1300, i3, 1, 0, null, this.xGR, 0, null, null, com.tencent.mm.game.report.f.a(null, null, Oy.xFX, null));
                }
                aVar.xUE.setVisibility(0);
                aVar.xUP.setVisibility(8);
                aVar.xUN.setText(com.tencent.mm.plugin.game.e.b.n(this.context, Oy.field_createTime * 1000));
                if (Oy.field_msgType != 100) {
                    aVar.nnM.setVisibility(8);
                    aVar.xUI.setVisibility(8);
                    aVar.xUJ.setVisibility(8);
                    aVar.xUL.setVisibility(8);
                    aVar.xUM.setVisibility(8);
                    aVar.xUO.setVisibility(8);
                    aVar.xUO.setEnabled(false);
                    aVar.xUM.setEnabled(false);
                    aVar.xUF.setEnabled(false);
                    aVar.gvw.setEnabled(false);
                    aVar.xUQ.setVisibility(8);
                    aVar.xUH.setVisibility(8);
                    if (!Util.isNullOrNil(Oy.xFe)) {
                        o.k kVar = Oy.xFe.get(0);
                        as Kn = ((l) g.af(l.class)).aSN().Kn(kVar.userName);
                        if (Kn != null) {
                            str = Kn.arJ();
                        } else {
                            str = null;
                        }
                        if (Util.isNullOrNil(str)) {
                            str = kVar.nickName;
                        }
                        z = !Util.isNullOrNil(kVar.xGq);
                    } else {
                        str = null;
                        z = false;
                    }
                    int size = Oy.xFe.size();
                    if (!Util.isNullOrNil(Oy.xFc) && (Oy.xFt & 1) == 0) {
                        aVar.xUO.setText(Oy.xFc);
                        aVar.xUO.setVisibility(0);
                        if ((Oy.xFt & 2) > 0) {
                            aVar.xUO.setTextColor(this.context.getResources().getColor(R.color.t5));
                            aVar.xUO.setBackgroundResource(R.drawable.a5r);
                            aVar.xUO.setOnClickListener(this.xUt);
                            aVar.xUO.setTag(Oy);
                            aVar.xUO.setEnabled(true);
                        } else {
                            aVar.xUO.setTextColor(this.context.getResources().getColor(R.color.sl));
                            aVar.xUO.setBackgroundResource(0);
                            aVar.xUO.setOnClickListener(null);
                            aVar.xUO.setEnabled(false);
                        }
                    }
                    if (Oy.field_msgType == 10 || Oy.field_msgType == 11) {
                        if (!Util.isNullOrNil(Oy.mAppName)) {
                            aVar.gvw.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, Oy.mAppName, aVar.gvw.getTextSize()), TextView.BufferType.SPANNABLE);
                            aVar.gvw.setVisibility(0);
                        } else if (!Util.isNullOrNil(str)) {
                            aVar.gvw.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, str, aVar.gvw.getTextSize()));
                            aVar.gvw.setVisibility(0);
                        } else {
                            aVar.gvw.setVisibility(8);
                        }
                    } else if (!Util.isNullOrNil(str)) {
                        aVar.gvw.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, str, aVar.gvw.getTextSize()));
                        aVar.gvw.setVisibility(0);
                        if (z) {
                            aVar.gvw.setOnClickListener(this.xUv);
                            aVar.gvw.setTag(Oy);
                            aVar.gvw.setEnabled(true);
                        }
                    } else {
                        aVar.gvw.setVisibility(8);
                    }
                    switch (Oy.field_msgType) {
                        case 2:
                            m(aVar.xUF, Oy.xEY);
                            String str3 = "礼物";
                            if (Oy.xFp.contains("爱心")) {
                                str3 = "爱心";
                            } else if (Oy.xFp.contains("体力")) {
                                str3 = "体力";
                            }
                            if (size > 1) {
                                aVar.nnM.setText(this.context.getResources().getString(R.string.drg, String.valueOf(size), str3));
                            } else {
                                aVar.nnM.setText(this.context.getResources().getString(R.string.drh, str3));
                            }
                            aVar.nnM.setVisibility(0);
                            a(Oy, aVar);
                            break;
                        case 3:
                        case 4:
                        case 7:
                        case 8:
                        case 9:
                        default:
                            Log.e("MicroMsg.GameMessageAdapter", "error msgtype: " + Oy.field_msgType);
                            break;
                        case 5:
                            if (!Util.isNullOrNil(Oy.xFe)) {
                                aVar.xUF.setVisibility(0);
                                if (!Util.isNullOrNil(Oy.xFe.get(0).xGp)) {
                                    m(aVar.xUF, Oy.xFe.get(0).xGp);
                                } else {
                                    k(aVar.xUF, Oy.xFe.get(0).userName);
                                }
                                if (!Util.isNullOrNil(Oy.xFe.get(0).xGq)) {
                                    aVar.xUF.setOnClickListener(this.xUw);
                                    aVar.xUF.setTag(Oy);
                                    aVar.xUF.setEnabled(true);
                                }
                            } else {
                                aVar.xUF.setVisibility(8);
                            }
                            if (size > 1) {
                                aVar.nnM.setText(this.context.getResources().getString(R.string.dra, String.valueOf(size)));
                                a(Oy, aVar);
                            } else {
                                aVar.nnM.setText(this.context.getResources().getString(R.string.drb));
                            }
                            aVar.xUJ.setVisibility(0);
                            aVar.nnM.setVisibility(0);
                            aVar.xUK.setText(Oy.xFB);
                            aVar.xUJ.setOnClickListener(this.xUu);
                            aVar.xUJ.setTag(Long.valueOf(Oy.field_msgId));
                            if (!Util.isNullOrNil(Oy.xFD)) {
                                aVar.xUL.setVisibility(0);
                                m(aVar.xUL, Oy.xFD);
                                break;
                            }
                            break;
                        case 6:
                            if (!Util.isNullOrNil(Oy.xFe)) {
                                aVar.xUF.setVisibility(0);
                                if (!Util.isNullOrNil(Oy.xFe.get(0).xGp)) {
                                    m(aVar.xUF, Oy.xFe.get(0).xGp);
                                } else {
                                    k(aVar.xUF, Oy.xFe.get(0).userName);
                                }
                                if (!Util.isNullOrNil(Oy.xFe.get(0).xGq)) {
                                    aVar.xUF.setOnClickListener(this.xUw);
                                    aVar.xUF.setTag(Oy);
                                    aVar.xUF.setEnabled(true);
                                }
                            } else {
                                aVar.xUF.setVisibility(8);
                            }
                            aVar.xUJ.setVisibility(0);
                            aVar.xUJ.setOnClickListener(this.xUu);
                            aVar.xUJ.setTag(Long.valueOf(Oy.field_msgId));
                            if (Oy.xFU != 1) {
                                if (Oy.xFU != 2) {
                                    if (Oy.xFU == 3) {
                                        aVar.nnM.setVisibility(0);
                                        if (size > 1) {
                                            aVar.nnM.setText(this.context.getResources().getString(R.string.dr9, String.valueOf(size)));
                                            a(Oy, aVar);
                                        } else {
                                            aVar.nnM.setText(this.context.getResources().getString(R.string.dr_));
                                        }
                                        aVar.xUK.setText(Oy.xFA);
                                        break;
                                    }
                                } else {
                                    aVar.xUI.setVisibility(0);
                                    aVar.xUI.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, Oy.xFx, aVar.xUI.getTextSize()));
                                    aVar.xUK.setText(Oy.xFy);
                                    break;
                                }
                            } else {
                                aVar.xUI.setVisibility(0);
                                aVar.xUI.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, Oy.xFx, aVar.xUI.getTextSize()));
                                aVar.xUK.setText(Oy.xFA);
                                break;
                            }
                            break;
                        case 10:
                        case 11:
                            if (!Util.isNullOrNil(Oy.xEY)) {
                                m(aVar.xUF, Oy.xEY);
                                aVar.xUF.setVisibility(0);
                            } else {
                                Log.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
                                aVar.xUF.setVisibility(8);
                            }
                            if (!Util.isNullOrNil(Oy.rfc)) {
                                if (!Util.isNullOrNil(Oy.xFk)) {
                                    aVar.xUI.setText(Oy.rfc);
                                    aVar.xUI.setVisibility(0);
                                } else {
                                    aVar.xUJ.setVisibility(0);
                                    aVar.xUK.setText(Oy.rfc);
                                    aVar.xUJ.setOnClickListener(this.xUu);
                                    aVar.xUJ.setTag(Long.valueOf(Oy.field_msgId));
                                }
                            }
                            if (!Util.isNullOrNil(Oy.xFk)) {
                                m(aVar.xUM, Oy.xFk);
                                aVar.xUM.setTag(Long.valueOf(Oy.field_msgId));
                                aVar.xUM.setOnTouchListener(xUs);
                                aVar.xUM.setOnClickListener(this.xUu);
                                aVar.xUM.setVisibility(0);
                                aVar.xUM.setEnabled(true);
                                break;
                            }
                            break;
                    }
                } else {
                    float f2 = Oy.xFg.xGj ? 0.083333336f : 0.0f;
                    if (Oy.xFJ != null) {
                        a(aVar.xUF, Oy.xFJ.xGn, f2);
                        aVar.xUF.setVisibility(0);
                        if (!Util.isNullOrNil(Oy.xFJ.xGm)) {
                            aVar.gvw.setText(Oy.xFJ.xGm);
                            aVar.gvw.setVisibility(0);
                        } else {
                            aVar.gvw.setVisibility(8);
                        }
                        if (!Util.isNullOrNil(Oy.xFJ.xGo)) {
                            m(aVar.xUH, Oy.xFJ.xGo);
                            aVar.xUH.setVisibility(0);
                        } else {
                            aVar.xUH.setVisibility(8);
                        }
                        if (!Util.isNullOrNil(Oy.xFJ.xGh)) {
                            aVar.gvw.setEnabled(true);
                            aVar.xUF.setEnabled(true);
                            p.a aVar3 = new p.a(Oy, Oy.xFJ.xGh, 1);
                            p.a aVar4 = new p.a(Oy, Oy.xFJ.xGh, 2);
                            aVar.gvw.setTag(aVar3);
                            aVar.gvw.setOnClickListener(this.xUB);
                            aVar.xUF.setTag(aVar4);
                            aVar.xUF.setOnClickListener(this.xUB);
                        } else {
                            aVar.gvw.setEnabled(false);
                            aVar.xUF.setEnabled(false);
                        }
                    } else if (!Util.isNullOrNil(Oy.xFe)) {
                        o.k kVar2 = Oy.xFe.get(0);
                        if (!Util.isNullOrNil(kVar2.nickName)) {
                            str2 = kVar2.nickName;
                        } else {
                            as Kn2 = ((l) g.af(l.class)).aSN().Kn(kVar2.userName);
                            if (Kn2 == null || Util.isNullOrNil(Kn2.arJ())) {
                                str2 = kVar2.userName;
                            } else {
                                str2 = Kn2.arJ();
                            }
                        }
                        if (!Util.isNullOrNil(kVar2.xGs)) {
                            aVar.gvw.setEnabled(true);
                            aVar.xUF.setEnabled(true);
                            p.a aVar5 = new p.a(Oy, kVar2.xGs, 1);
                            p.a aVar6 = new p.a(Oy, kVar2.xGs, 2);
                            aVar.gvw.setTag(aVar5);
                            aVar.gvw.setOnClickListener(this.xUB);
                            aVar.xUF.setTag(aVar6);
                            aVar.xUF.setOnClickListener(this.xUB);
                        } else {
                            aVar.gvw.setEnabled(false);
                            aVar.xUF.setEnabled(false);
                        }
                        if (!Util.isNullOrNil(str2)) {
                            aVar.gvw.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, str2, aVar.gvw.getTextSize()), TextView.BufferType.SPANNABLE);
                            aVar.gvw.setVisibility(0);
                        } else {
                            aVar.gvw.setVisibility(8);
                        }
                        aVar.xUF.setVisibility(0);
                        if (!Util.isNullOrNil(kVar2.xGp)) {
                            a(aVar.xUF, kVar2.xGp, f2);
                        } else {
                            k(aVar.xUF, kVar2.userName);
                        }
                        if (!Util.isNullOrNil(kVar2.xGr)) {
                            m(aVar.xUH, kVar2.xGr);
                            aVar.xUH.setVisibility(0);
                        } else {
                            aVar.xUH.setVisibility(8);
                        }
                    } else {
                        aVar.xUF.setVisibility(8);
                        aVar.gvw.setVisibility(8);
                        aVar.xUH.setVisibility(8);
                    }
                    if (!Util.isNullOrNil(Oy.xFF)) {
                        int size2 = Oy.xFe.size();
                        if (size2 > 1) {
                            aVar.nnM.setText(this.context.getResources().getString(R.string.dri, Integer.valueOf(size2)) + Oy.xFF);
                        } else {
                            aVar.nnM.setText(Oy.xFF);
                        }
                        aVar.nnM.setVisibility(0);
                    } else {
                        aVar.nnM.setVisibility(8);
                    }
                    if (!Util.isNullOrNil(Oy.xFG)) {
                        aVar.xUI.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, Oy.xFG, aVar.xUI.getTextSize()));
                        aVar.xUI.setVisibility(0);
                    } else {
                        aVar.xUI.setVisibility(8);
                    }
                    a(Oy, aVar);
                    if (!Util.isNullOrNil(Oy.xFK.mContent)) {
                        aVar.xUJ.setVisibility(0);
                        if (!Util.isNullOrNil(Oy.xFK.xGh)) {
                            aVar.xUJ.setTag(new p.a(Oy, Oy.xFK.xGh, 3));
                            aVar.xUJ.setOnClickListener(this.xUB);
                            aVar.xUJ.setEnabled(true);
                        } else {
                            aVar.xUJ.setEnabled(false);
                        }
                        aVar.xUK.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.context, Oy.xFK.mContent, aVar.xUK.getTextSize()));
                        if (!Util.isNullOrNil(Oy.xFK.xGg)) {
                            m(aVar.xUL, Oy.xFK.xGg);
                            aVar.xUL.setVisibility(0);
                        } else {
                            aVar.xUL.setVisibility(8);
                        }
                    } else {
                        aVar.xUJ.setVisibility(8);
                    }
                    if (!Util.isNullOrNil(Oy.xFH)) {
                        m(aVar.xUM, Oy.xFH);
                        aVar.xUM.setVisibility(0);
                        if (!Util.isNullOrNil(Oy.xFI)) {
                            aVar.xUM.setTag(new p.a(Oy, Oy.xFI, 3));
                            aVar.xUM.setOnClickListener(this.xUB);
                            aVar.xUM.setEnabled(true);
                        } else {
                            aVar.xUM.setEnabled(false);
                        }
                    } else {
                        aVar.xUM.setVisibility(8);
                    }
                    if (!Util.isNullOrNil(Oy.xFL.mName)) {
                        aVar.xUO.setText(Oy.xFL.mName);
                        aVar.xUO.setVisibility(0);
                        if (!Util.isNullOrNil(Oy.xFL.xGh)) {
                            aVar.xUO.setTag(new p.a(Oy, Oy.xFL.xGh, 5));
                            aVar.xUO.setOnClickListener(this.xUB);
                            aVar.xUO.setEnabled(true);
                        } else {
                            aVar.xUO.setEnabled(false);
                        }
                    } else {
                        aVar.xUO.setVisibility(8);
                    }
                    AppMethodBeat.o(42260);
                    return view;
                }
            }
        } else {
            aVar.xUE.setVisibility(8);
            aVar.xUP.setVisibility(0);
        }
        AppMethodBeat.o(42260);
        return view;
    }

    private void a(o oVar, a aVar) {
        AppMethodBeat.i(42261);
        LinkedList<o.k> linkedList = new LinkedList<>();
        for (int i2 = 1; i2 < oVar.xFe.size(); i2++) {
            linkedList.add(oVar.xFe.get(i2));
        }
        aVar.xUQ.a(oVar, linkedList, this.xUy, this.xGR, this.xUC);
        AppMethodBeat.o(42261);
    }

    private void k(ImageView imageView, String str) {
        AppMethodBeat.i(42262);
        if (Util.isNullOrNil(str)) {
            a.b.c(imageView, str);
            AppMethodBeat.o(42262);
        } else if (!this.xUC.check(str)) {
            l(imageView, str);
            AppMethodBeat.o(42262);
        } else {
            Bitmap bitmap = this.xUC.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                l(imageView, str);
                AppMethodBeat.o(42262);
                return;
            }
            imageView.setImageBitmap(bitmap);
            AppMethodBeat.o(42262);
        }
    }

    private void l(ImageView imageView, String str) {
        AppMethodBeat.i(42263);
        Bitmap q = e.dWR().q(imageView, str);
        if (q != null) {
            this.xUC.put(str, q);
        }
        AppMethodBeat.o(42263);
    }

    private void m(ImageView imageView, String str) {
        AppMethodBeat.i(42264);
        if (this.xUC.check(str)) {
            Bitmap bitmap = this.xUC.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                b(imageView, str, 0.0f);
                AppMethodBeat.o(42264);
                return;
            }
            imageView.setImageBitmap(bitmap);
            AppMethodBeat.o(42264);
            return;
        }
        b(imageView, str, 0.0f);
        AppMethodBeat.o(42264);
    }

    private void a(ImageView imageView, String str, float f2) {
        AppMethodBeat.i(42265);
        if (this.xUC.check(str)) {
            Bitmap bitmap = this.xUC.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                b(imageView, str, f2);
                AppMethodBeat.o(42265);
                return;
            }
            imageView.setImageBitmap(bitmap);
            AppMethodBeat.o(42265);
            return;
        }
        b(imageView, str, f2);
        AppMethodBeat.o(42265);
    }

    private void b(ImageView imageView, final String str, float f2) {
        AppMethodBeat.i(42266);
        e.a.C1397a aVar = new e.a.C1397a();
        aVar.jbd = false;
        aVar.xZw = f2;
        e.dWR().a(imageView, str, aVar.dWS(), new e.b() {
            /* class com.tencent.mm.plugin.game.ui.n.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.game.e.e.b
            public final void a(View view, Bitmap bitmap) {
                AppMethodBeat.i(42258);
                if (bitmap != null && !bitmap.isRecycled()) {
                    n.this.xUC.put(str, bitmap);
                }
                AppMethodBeat.o(42258);
            }
        });
        AppMethodBeat.o(42266);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public TextView gvw;
        public TextView nnM;
        public LinearLayout xUE;
        public ImageView xUF;
        public LinearLayout xUG;
        public ImageView xUH;
        public TextView xUI;
        public LinearLayout xUJ;
        public TextView xUK;
        public ImageView xUL;
        public ImageView xUM;
        public TextView xUN;
        public TextView xUO;
        public LinearLayout xUP;
        public GameMessageListContainerView xUQ;

        a() {
        }
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(42267);
        setCursor(((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().rawQuery("select * from GameRawMessage where " + com.tencent.mm.plugin.game.model.s.D(2, 5, 6, 10, 11, 100) + " and showInMsgList = 1 and isHidden = 0" + " order by isRead, createTime desc limit " + this.qdp, new String[0]));
        this.qdp = getCount();
        if (this.OFI != null) {
            this.OFI.bnE();
        }
        dWv();
        super.notifyDataSetChanged();
        AppMethodBeat.o(42267);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(42268);
        ebf();
        anp();
        AppMethodBeat.o(42268);
    }

    private static o a(o oVar, Cursor cursor) {
        AppMethodBeat.i(42269);
        if (oVar == null) {
            oVar = new o();
        }
        oVar.convertFrom(cursor);
        AppMethodBeat.o(42269);
        return oVar;
    }

    public final boolean cwg() {
        return this.qdp >= this.gAZ;
    }

    public final void dWt() {
        AppMethodBeat.i(42270);
        if (cwg()) {
            if (this.OFI != null) {
                this.OFI.bnE();
            }
            AppMethodBeat.o(42270);
            return;
        }
        this.qdp += 15;
        if (this.qdp > this.gAZ) {
            this.qdp = this.gAZ;
        }
        AppMethodBeat.o(42270);
    }

    @Override // com.tencent.mm.ui.s
    public final int getCount() {
        AppMethodBeat.i(42271);
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        if (this.count <= 0) {
            AppMethodBeat.o(42271);
            return 0;
        }
        int dWu = this.count + dWu();
        AppMethodBeat.o(42271);
        return dWu;
    }

    @Override // com.tencent.mm.ui.s
    public final boolean Ox(int i2) {
        return this.gAZ > this.dCm && this.dCm > 0 && i2 == this.dCm;
    }

    @Override // com.tencent.mm.ui.s
    public final int dWu() {
        return (this.gAZ <= this.dCm || this.dCm <= 0) ? 0 : 1;
    }

    private o Oy(int i2) {
        int i3;
        o oVar;
        AppMethodBeat.i(42272);
        if (Ox(i2)) {
            o oVar2 = (o) this.OFE;
            AppMethodBeat.o(42272);
            return oVar2;
        } else if (this.OFH == null || (oVar = (o) this.OFH.get(Integer.valueOf(i2))) == null) {
            if (Oz(i2)) {
                i3 = i2 - 1;
            } else {
                i3 = i2;
            }
            if (i2 < 0 || !getCursor().moveToPosition(i3)) {
                AppMethodBeat.o(42272);
                return null;
            } else if (this.OFH == null) {
                o a2 = a((o) this.OFE, getCursor());
                AppMethodBeat.o(42272);
                return a2;
            } else {
                o a3 = a((o) null, getCursor());
                this.OFH.put(Integer.valueOf(i2), a3);
                AppMethodBeat.o(42272);
                return a3;
            }
        } else {
            AppMethodBeat.o(42272);
            return oVar;
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange, com.tencent.mm.ui.s
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(42273);
        getCursor().close();
        anp();
        AppMethodBeat.o(42273);
    }

    private void dWv() {
        AppMethodBeat.i(42274);
        if (this.xUA <= 0) {
            AppMethodBeat.o(42274);
            return;
        }
        int count = getCount();
        int i2 = 0;
        while (true) {
            if (i2 < count) {
                o Oy = Oy(i2);
                if (Oy != null && Oy.field_msgId == this.xUA) {
                    this.xUz = i2;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        this.xUA = 0;
        AppMethodBeat.o(42274);
    }

    private boolean Oz(int i2) {
        return this.gAZ > this.dCm && this.dCm > 0 && i2 > this.dCm;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.ui.s
    public final /* bridge */ /* synthetic */ o dWw() {
        return (o) this.OFE;
    }
}
