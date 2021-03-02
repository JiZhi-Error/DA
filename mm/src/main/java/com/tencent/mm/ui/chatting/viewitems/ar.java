package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.contact.e;
import junit.framework.Assert;

public final class ar {

    public static class a extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (i2 == 37 || i2 == 40) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37295);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.rz);
                view.setTag(new b().hd(view));
            }
            AppMethodBeat.o(37295);
            return view;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTU() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(37296);
            this.PhN = aVar2;
            b bVar = (b) aVar;
            if (caVar.getType() == 37) {
                bg.aVF();
                ca.d aEJ = com.tencent.mm.model.c.aSQ().aEJ(caVar.field_content);
                if (aEJ == null || aEJ.dkU == null || aEJ.dkU.length() <= 0) {
                    Log.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse verify msg failed");
                    AppMethodBeat.o(37296);
                    return;
                }
                com.tencent.mm.aj.c.ap(aEJ.dkU, aEJ.OqJ);
                if (ab.IS(aEJ.dkU)) {
                    bVar.PNM.setVisibility(8);
                    bVar.PNN.setVisibility(8);
                    bVar.PNO.setVisibility(0);
                    bVar.PNL.setBackgroundColor(16777215);
                    bVar.PNO.setText(aVar2.Pwc.getMMResources().getString(R.string.diy));
                } else {
                    bVar.PNM.setVisibility(0);
                    bVar.PNN.setVisibility(0);
                    bVar.PNO.setVisibility(0);
                    bVar.PNL.setBackgroundResource(R.drawable.o4);
                    bVar.PNO.setText(aVar2.Pwc.getMMResources().getString(R.string.dix));
                }
                switch (aEJ.scene) {
                    case 13:
                        com.tencent.mm.plugin.account.friend.a.a SR = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(aEJ.dkU);
                        if (SR != null && SR.bnK() != null && !SR.bnK().equals("")) {
                            bVar.PNP.setVisibility(0);
                            bVar.PNP.setText(aVar2.Pwc.getMMResources().getString(R.string.ayf, SR.bnK()));
                            break;
                        } else {
                            bVar.PNP.setVisibility(8);
                            break;
                        }
                        break;
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 19:
                    case 20:
                    case 21:
                    default:
                        bVar.PKu.setText(R.string.ayn);
                        break;
                    case 18:
                        bVar.PKu.setText(R.string.ayr);
                        break;
                    case 22:
                    case 23:
                    case 24:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                        bVar.PKu.setText(R.string.ayt);
                        break;
                    case 25:
                        bVar.PKu.setText(R.string.aym);
                        break;
                    case 30:
                        bVar.PKu.setText(R.string.fso);
                        break;
                }
                bVar.kqG.setText(l.b(aVar2.Pwc.getContext(), aEJ.getDisplayName(), bVar.kqG.getTextSize()));
                D(bVar.avatarIV, aEJ.dkU);
                bVar.PNK.setVisibility(0);
                if (aEJ.content == null || aEJ.content.trim().equals("")) {
                    bVar.PNK.setText(aVar2.Pwc.getMMResources().getString(R.string.ays));
                } else {
                    bVar.PNK.setText(aEJ.content);
                }
            } else if (caVar.getType() == 40) {
                bg.aVF();
                ca.a aEK = com.tencent.mm.model.c.aSQ().aEK(caVar.field_content);
                if (aEK == null || aEK.dkU == null || aEK.dkU.length() <= 0) {
                    Log.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse possible friend msg failed");
                    AppMethodBeat.o(37296);
                    return;
                }
                com.tencent.mm.aj.c.ap(aEK.dkU, aEK.OqJ);
                if (ab.IS(aEK.dkU)) {
                    bVar.PNM.setVisibility(8);
                    bVar.PNN.setVisibility(8);
                    bVar.PNO.setVisibility(0);
                    bVar.PNL.setBackgroundColor(16777215);
                    bVar.PNO.setText(aVar2.Pwc.getMMResources().getString(R.string.diy));
                } else {
                    bVar.PNM.setVisibility(0);
                    bVar.PNN.setVisibility(0);
                    bVar.PNO.setVisibility(0);
                    bVar.PNL.setBackgroundResource(R.drawable.o4);
                    bVar.PNO.setText(aVar2.Pwc.getMMResources().getString(R.string.dix));
                }
                switch (aEK.scene) {
                    case 4:
                        bVar.PKu.setText(R.string.ay_);
                        bVar.PNK.setText(R.string.aya);
                        String gDZ = aEK.gDZ();
                        if (gDZ == null) {
                            gDZ = aEK.getDisplayName();
                        }
                        bVar.kqG.setText(l.b(aVar2.Pwc.getContext(), gDZ, bVar.kqG.getTextSize()));
                        break;
                    case 10:
                    case 11:
                        bVar.PKu.setText(R.string.aye);
                        String Tc = com.tencent.mm.plugin.account.friend.a.l.Tc(aEK.OqK);
                        if (Util.isNullOrNil(Tc)) {
                            Tc = com.tencent.mm.plugin.account.friend.a.l.Tc(aEK.OqL);
                        }
                        bVar.PNK.setText(aVar2.Pwc.getMMResources().getString(R.string.ayf, Tc));
                        bVar.kqG.setText(l.b(aVar2.Pwc.getContext(), aEK.getDisplayName(), bVar.kqG.getTextSize()));
                        break;
                    case 31:
                        bVar.PKu.setText(R.string.ayp);
                        bVar.PNK.setText(R.string.ayq);
                        bVar.kqG.setText(l.b(aVar2.Pwc.getContext(), aEK.getDisplayName(), bVar.kqG.getTextSize()));
                        break;
                    case 32:
                        bVar.PKu.setText(R.string.ayl);
                        bVar.PNK.setText(R.string.ayk);
                        bVar.kqG.setText(l.b(aVar2.Pwc.getContext(), aEK.getDisplayName(), bVar.kqG.getTextSize()));
                        break;
                    default:
                        Log.d("MicroMsg.ChattingItemFMessageFrom", "prossible friend sceneType:%d", Integer.valueOf(aEK.scene));
                        bVar.PKu.setText(R.string.ayi);
                        bVar.PNK.setText(R.string.ayj);
                        bVar.kqG.setText(l.b(aVar2.Pwc.getContext(), aEK.getDisplayName(), bVar.kqG.getTextSize()));
                        break;
                }
                D(bVar.avatarIV, aEK.dkU);
            } else {
                Log.w("MicroMsg.ChattingItemFMessageFrom", "FROM_FMESSAGE did not include this type, msgType = " + caVar.getType());
            }
            bVar.clickArea.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
            bVar.clickArea.setOnClickListener(d(aVar2));
            bVar.clickArea.setOnLongClickListener(c(aVar2));
            bVar.clickArea.setOnTouchListener(((k) aVar2.bh(k.class)).gOC());
            AppMethodBeat.o(37296);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37297);
            if (caVar.getType() == 37) {
                String str = caVar.field_content;
                Log.w("MicroMsg.ChattingItemFMessageFrom", "dealClickVerifyMsgEvent : ".concat(String.valueOf(str)));
                if (str != null && str.length() > 0) {
                    bg.aVF();
                    ca.d aEJ = com.tencent.mm.model.c.aSQ().aEJ(str);
                    if (aEJ != null) {
                        Assert.assertTrue(aEJ.dkU.length() > 0);
                        bg.aVF();
                        as Kn = com.tencent.mm.model.c.aSN().Kn(aEJ.dkU);
                        Intent intent = new Intent();
                        if (Kn == null || ((int) Kn.gMZ) <= 0 || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                            intent.putExtra("Verify_ticket", aEJ.wZz);
                            intent.putExtra("User_Verify", true);
                            intent.putExtra("Contact_User", aEJ.dkU);
                            intent.putExtra("Contact_Alias", aEJ.fMb);
                            intent.putExtra("Contact_Nick", aEJ.nickname);
                            intent.putExtra("Contact_QuanPin", aEJ.kfR);
                            intent.putExtra("Contact_PyInitial", aEJ.kfQ);
                            intent.putExtra("Contact_Sex", aEJ.fuA);
                            intent.putExtra("Contact_Signature", aEJ.signature);
                            intent.putExtra("Contact_Scene", aEJ.scene);
                            intent.putExtra("Contact_FMessageCard", true);
                            intent.putExtra("Contact_City", aEJ.getCity());
                            intent.putExtra("Contact_Province", aEJ.getProvince());
                            intent.putExtra("Contact_Mobile_MD5", aEJ.OqK);
                            intent.putExtra("Contact_full_Mobile_MD5", aEJ.OqL);
                            intent.putExtra("Contact_KSnsIFlag", aEJ.OqX);
                            intent.putExtra("Contact_KSnsBgUrl", aEJ.OqY);
                        } else {
                            intent.putExtra("Contact_User", Kn.field_username);
                            e.a(intent, Kn.field_username);
                        }
                        String str2 = aEJ.content;
                        if (Util.nullAsNil(str2).length() <= 0) {
                            switch (aEJ.scene) {
                                case 18:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                case 26:
                                case 27:
                                case 28:
                                case 29:
                                    str2 = this.PhN.Pwc.getMMResources().getString(R.string.ays);
                                    break;
                                case 19:
                                case 20:
                                case 21:
                                default:
                                    str2 = this.PhN.Pwc.getMMResources().getString(R.string.ayo);
                                    break;
                            }
                        }
                        intent.putExtra("Contact_Content", str2);
                        intent.putExtra("Contact_verify_Scene", aEJ.scene);
                        intent.putExtra("Contact_Uin", aEJ.Bge);
                        intent.putExtra("Contact_QQNick", aEJ.kfS);
                        intent.putExtra("Contact_Mobile_MD5", aEJ.OqK);
                        intent.putExtra("User_From_Fmessage", true);
                        intent.putExtra("Contact_from_msgType", 37);
                        intent.putExtra("Contact_KSnsIFlag", aEJ.OqX);
                        intent.putExtra("Contact_KSnsBgUrl", aEJ.OqY);
                        com.tencent.mm.br.c.b(this.PhN.Pwc.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                        com.tencent.mm.bs.a.aiT(aEJ.scene);
                    }
                }
            } else if (caVar.getType() == 40) {
                String str3 = caVar.field_content;
                bg.aVF();
                ca.a aEK = com.tencent.mm.model.c.aSQ().aEK(str3);
                if (aEK != null && aEK.dkU.length() > 0) {
                    com.tencent.mm.bs.a.aiT(aEK.scene);
                    bg.aVF();
                    as Kn2 = com.tencent.mm.model.c.aSN().Kn(aEK.dkU);
                    if (Kn2 != null && ((int) Kn2.gMZ) > 0 && com.tencent.mm.contact.c.oR(Kn2.field_type)) {
                        e.a(this.PhN.Pwc.getContext(), Kn2, aEK);
                    } else if (aEK.Bge > 0 || (Util.isNullOrNil(aEK.OqK) && Util.isNullOrNil(aEK.OqL))) {
                        e.a(this.PhN.Pwc.getContext(), aEK);
                    } else {
                        com.tencent.mm.plugin.account.friend.a.a SU = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(aEK.OqK);
                        if ((SU == null || SU.getMd5() == null || SU.getMd5().length() <= 0) && ((SU = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(aEK.OqL)) == null || SU.getMd5() == null || SU.getMd5().length() <= 0)) {
                            if (Kn2 == null || ((int) Kn2.gMZ) <= 0) {
                                e.a(this.PhN.Pwc.getContext(), aEK);
                            } else {
                                e.a(this.PhN.Pwc.getContext(), Kn2, aEK);
                            }
                            Log.e("MicroMsg.ChattingItemFMessageFrom", "error : this is not the mobile contact, MD5 = " + aEK.OqK + " fullMD5:" + aEK.OqL);
                        } else {
                            if (SU.getUsername() == null || SU.getUsername().length() <= 0) {
                                SU.username = aEK.dkU;
                                SU.cSx = 128;
                                if (com.tencent.mm.plugin.account.a.getAddrUploadStg().a(SU.getMd5(), SU) == -1) {
                                    Log.e("MicroMsg.ChattingItemFMessageFrom", "update mobile contact username failed");
                                }
                            }
                            e.a(this.PhN.Pwc.getContext(), aEK);
                        }
                    }
                }
            }
            AppMethodBeat.o(37297);
            return true;
        }
    }

    static class b extends c.a {
        TextView PKu;
        TextView PNK;
        View PNL;
        ImageView PNM;
        ImageView PNN;
        TextView PNO;
        TextView PNP;
        TextView kqG;

        b() {
        }

        public final c.a hd(View view) {
            AppMethodBeat.i(37298);
            super.create(view);
            this.timeTV = (TextView) view.findViewById(R.id.ayf);
            this.PKu = (TextView) view.findViewById(R.id.ayj);
            this.kqG = (TextView) view.findViewById(R.id.ayo);
            this.PNK = (TextView) view.findViewById(R.id.auk);
            this.clickArea = view.findViewById(R.id.auf);
            this.PNP = (TextView) view.findViewById(R.id.ax6);
            this.PNL = view.findViewById(R.id.avh);
            this.PNM = (ImageView) view.findViewById(R.id.ar_);
            this.PNN = (ImageView) view.findViewById(R.id.avi);
            this.PNO = (TextView) view.findViewById(R.id.ara);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            AppMethodBeat.o(37298);
            return this;
        }
    }
}
