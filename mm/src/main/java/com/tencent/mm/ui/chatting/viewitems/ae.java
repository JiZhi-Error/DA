package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.j;
import com.tencent.mm.ag.k;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.aag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.smtt.sdk.TbsListener;

public final class ae {

    public static class c extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 419430449) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37051);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.t5);
                view.setTag(new a().gZ(view));
            }
            AppMethodBeat.o(37051);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            String str2;
            String str3;
            String str4;
            String str5;
            SpannableString c2;
            String str6;
            String str7;
            AppMethodBeat.i(37052);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str8 = caVar.field_content;
            if (str8 != null) {
                bVar = k.b.aD(str8, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                aVar3.resetChatBubbleWidth(aVar3.clickArea, aVar3.PJa);
                aVar3.clickArea.setBackgroundResource(R.drawable.kn);
                aVar3.clickArea.setPadding(0, 0, 0, 0);
                aVar3.PLD.setSingleLine(true);
                aag aag = new aag();
                aag.ehb.dQp = bVar.ixQ;
                EventCenter.instance.publish(aag);
                boolean z = aag.ehc.ehd;
                if (aag.ehc.status == -2) {
                    z = false;
                }
                int i3 = aag.ehc.status;
                if (i3 <= 0) {
                    i3 = bVar.ixN;
                }
                if (aVar3.qdl != null) {
                    if (ao.isDarkMode()) {
                        aVar3.PLC.setAlpha(0.8f);
                        aVar3.PLD.setAlpha(0.8f);
                        aVar3.PLE.setAlpha(0.8f);
                        aVar3.PLF.setAlpha(0.5f);
                    } else {
                        aVar3.PLC.setAlpha(1.0f);
                        aVar3.PLD.setAlpha(1.0f);
                        aVar3.PLE.setAlpha(1.0f);
                        aVar3.PLF.setAlpha(0.8f);
                    }
                    aVar3.qdl.setBackgroundResource(R.color.ac_);
                    aVar3.HMl.setVisibility(0);
                }
                switch (i3) {
                    case 1:
                    case 7:
                        bg.aVF();
                        as bjK = com.tencent.mm.model.c.aSN().bjK(caVar.field_talker);
                        if (bjK != null) {
                            str5 = bjK.arJ();
                        } else {
                            str5 = caVar.field_talker;
                        }
                        j jVar = (j) bVar.as(j.class);
                        if (aVar2.gRM()) {
                            aVar3.PLD.setText(R.string.azf);
                        } else if (af.isNullOrNil(bVar.iyX)) {
                            String string = aVar2.Pwc.getMMResources().getString(R.string.azg, af.nullAsNil(str5));
                            if (!Util.isEqual(jVar.iwA, 1)) {
                                str7 = string;
                            } else if (string.length() > 5) {
                                str7 = string.substring(0, 5) + "..." + MMApplicationContext.getContext().getString(R.string.azi);
                            } else {
                                str7 = string + MMApplicationContext.getContext().getString(R.string.azi);
                            }
                            aVar3.PLD.setText(l.b(aVar2.Pwc.getContext(), str7, aVar3.PLD.getTextSize()));
                        } else {
                            if (Util.isEqual(jVar.iwA, 1)) {
                                if (bVar.iyX.length() > 5) {
                                    str6 = bVar.iyX.substring(0, 5) + "..." + MMApplicationContext.getContext().getString(R.string.azi);
                                } else {
                                    str6 = bVar.iyX + aVar2.Pwc.getContext().getString(R.string.azi);
                                }
                                c2 = l.c(aVar2.Pwc.getContext(), str6);
                            } else {
                                c2 = l.c(aVar2.Pwc.getContext(), bVar.iyX);
                            }
                            aVar3.PLD.setText(c2);
                        }
                        aVar3.PLE.setText(bVar.ixO);
                        aVar3.PLC.setImageResource(R.raw.c2c_remittance_icon);
                        break;
                    case 2:
                        if (aVar2.gRM()) {
                            aVar3.PLD.setText(R.string.azo);
                        } else if (af.isNullOrNil(bVar.iyX)) {
                            aVar3.PLD.setText(R.string.azn);
                        } else {
                            aVar3.PLD.setText(MMApplicationContext.getContext().getString(R.string.azn) + "-" + bVar.iyX);
                        }
                        aVar3.PLE.setText(bVar.ixO);
                        aVar3.PLC.setImageResource(R.raw.c2c_remittance_icon);
                        a(aVar3);
                        break;
                    case 3:
                        if (aVar2.gRM()) {
                            aVar3.PLD.setText(R.string.az4);
                        } else if (z) {
                            if (Util.isEqual(((j) bVar.as(j.class)).iwA, 1)) {
                                if (af.isNullOrNil(bVar.iyX)) {
                                    str4 = MMApplicationContext.getContext().getString(R.string.az6) + MMApplicationContext.getContext().getString(R.string.azi);
                                } else {
                                    str4 = MMApplicationContext.getContext().getString(R.string.az6) + "-" + bVar.iyX;
                                    if (str4.length() > 5) {
                                        str4 = str4.substring(0, 5) + "..." + MMApplicationContext.getContext().getString(R.string.azi);
                                    }
                                }
                            } else if (af.isNullOrNil(bVar.iyX)) {
                                str4 = MMApplicationContext.getContext().getString(R.string.az6);
                            } else {
                                str4 = MMApplicationContext.getContext().getString(R.string.az6) + "-" + bVar.iyX;
                            }
                            aVar3.PLD.setText(l.c(aVar2.Pwc.getContext(), str4));
                        } else {
                            aVar3.PLD.setText(R.string.az7);
                        }
                        aVar3.PLE.setText(bVar.ixO);
                        aVar3.PLC.setImageResource(R.raw.c2c_remittance_received_icon);
                        a(aVar3);
                        break;
                    case 4:
                        if (aVar2.gRM()) {
                            aVar3.PLD.setText(R.string.azj);
                        } else if (z) {
                            if (af.isNullOrNil(bVar.iyX)) {
                                str3 = MMApplicationContext.getContext().getString(R.string.azl);
                            } else {
                                str3 = MMApplicationContext.getContext().getString(R.string.azl) + "-" + bVar.iyX;
                            }
                            aVar3.PLD.setText(l.c(aVar2.Pwc.getContext(), str3));
                        } else {
                            aVar3.PLD.setText(R.string.azk);
                        }
                        aVar3.PLE.setText(bVar.ixO);
                        aVar3.PLC.setImageResource(R.raw.c2c_remittance_cancle_icon);
                        a(aVar3);
                        break;
                    case 5:
                        if (aVar2.gRM()) {
                            aVar3.PLD.setText(R.string.aze);
                        } else if (z) {
                            if (af.isNullOrNil(bVar.iyX)) {
                                str2 = MMApplicationContext.getContext().getString(R.string.azc);
                            } else {
                                str2 = MMApplicationContext.getContext().getString(R.string.azc) + "-" + bVar.iyX;
                            }
                            aVar3.PLD.setText(l.c(aVar2.Pwc.getContext(), str2));
                        } else {
                            aVar3.PLD.setText(R.string.azd);
                        }
                        aVar3.PLE.setText(bVar.ixO);
                        aVar3.PLC.setImageResource(R.raw.c2c_remittance_received_icon);
                        a(aVar3);
                        break;
                    case 6:
                        if (af.isNullOrNil(bVar.iyX)) {
                            aVar3.PLD.setText(R.string.az8);
                        } else {
                            aVar3.PLD.setText(MMApplicationContext.getContext().getString(R.string.az8) + "-" + bVar.iyX);
                        }
                        aVar3.PLE.setText(bVar.ixO);
                        aVar3.PLC.setImageResource(R.raw.c2c_remittance_cancle_icon);
                        a(aVar3);
                        break;
                    default:
                        aVar3.PLC.setImageResource(R.raw.c2c_remittance_icon);
                        aVar3.PLD.setSingleLine(false);
                        aVar3.PLD.setMaxLines(2);
                        aVar3.PLE.setText((CharSequence) null);
                        aVar3.PLD.setText(bVar.description);
                        break;
                }
                aVar3.clickArea.setOnClickListener(d(aVar2));
                aVar3.clickArea.setOnLongClickListener(c(aVar2));
                aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                aVar3.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
            }
            AppMethodBeat.o(37052);
        }

        private static void a(a aVar) {
            AppMethodBeat.i(37053);
            aVar.clickArea.getPaddingLeft();
            aVar.clickArea.getPaddingTop();
            aVar.clickArea.getPaddingRight();
            aVar.clickArea.getPaddingBottom();
            aVar.clickArea.setBackgroundResource(R.drawable.ko);
            aVar.clickArea.setPadding(0, 0, 0, 0);
            if (aVar.qdl != null) {
                if (ao.isDarkMode()) {
                    aVar.PLC.setAlpha(0.3f);
                    aVar.PLD.setAlpha(0.3f);
                    aVar.PLE.setAlpha(0.3f);
                    aVar.PLF.setAlpha(0.3f);
                } else {
                    aVar.PLC.setAlpha(1.0f);
                    aVar.PLD.setAlpha(1.0f);
                    aVar.PLE.setAlpha(1.0f);
                    aVar.PLF.setAlpha(0.8f);
                }
                aVar.qdl.setBackgroundResource(R.color.ac_);
                aVar.HMl.setVisibility(0);
            }
            AppMethodBeat.o(37053);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233792);
            int i2 = ((bq) view.getTag()).position;
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (bVar != null) {
                mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            }
            AppMethodBeat.o(233792);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, final com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37055);
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (bVar != null) {
                Intent intent = new Intent();
                intent.putExtra("sender_name", caVar.field_talker);
                switch (bVar.ixN) {
                    case 1:
                    case 7:
                        intent.putExtra("invalid_time", bVar.ixR);
                        intent.putExtra("is_sender", true);
                        intent.putExtra("appmsg_type", bVar.ixN);
                        intent.putExtra("transfer_id", bVar.ixQ);
                        intent.putExtra(FirebaseAnalytics.b.TRANSACTION_ID, bVar.ixP);
                        intent.putExtra("effective_date", bVar.ixS);
                        intent.putExtra("total_fee", bVar.dYg);
                        intent.putExtra("fee_type", bVar.dFv);
                        AnonymousClass1 r5 = new c.a() {
                            /* class com.tencent.mm.ui.chatting.viewitems.ae.c.AnonymousClass1 */

                            @Override // com.tencent.mm.br.c.a
                            public final void onActivityResult(int i2, int i3, Intent intent) {
                                AppMethodBeat.i(37050);
                                if (i2 != 221) {
                                    AppMethodBeat.o(37050);
                                } else if (intent == null) {
                                    AppMethodBeat.o(37050);
                                } else {
                                    String stringExtra = intent.getStringExtra("result_msg");
                                    if (!Util.isNullOrNil(stringExtra)) {
                                        h.c(aVar.Pwc.getContext(), stringExtra, "", false);
                                    }
                                    AppMethodBeat.o(37050);
                                }
                            }
                        };
                        if (!z.aUo()) {
                            com.tencent.mm.br.c.a(aVar.Pwa, "remittance", ".ui.RemittanceDetailUI", intent, (int) TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, r5);
                            break;
                        } else {
                            com.tencent.mm.br.c.a(aVar.Pwa, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent, (int) TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, r5);
                            break;
                        }
                    case 2:
                    default:
                        Log.w("MicroMsg.ChattingItemAppMsgRemittanceTo", "Unrecognized type %d, probably version to low & check update!", Integer.valueOf(bVar.ixN));
                        af.dA(aVar.Pwc.getContext());
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        intent.putExtra("appmsg_type", bVar.ixN);
                        intent.putExtra("transfer_id", bVar.ixQ);
                        intent.putExtra(FirebaseAnalytics.b.TRANSACTION_ID, bVar.ixP);
                        intent.putExtra("effective_date", bVar.ixS);
                        intent.putExtra("total_fee", bVar.dYg);
                        intent.putExtra("fee_type", bVar.dFv);
                        if (!z.aUo()) {
                            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "remittance", ".ui.RemittanceDetailUI", intent);
                            break;
                        } else {
                            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent);
                            break;
                        }
                }
                AppMethodBeat.o(37055);
                return true;
            }
            AppMethodBeat.o(37055);
            return false;
        }
    }

    public static class b extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 419430449) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37044);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.rr);
                view.setTag(new a().gZ(view));
            }
            AppMethodBeat.o(37044);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            String str2;
            String str3;
            String str4;
            SpannableString c2;
            String str5;
            AppMethodBeat.i(37045);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str6 = caVar.field_content;
            if (str6 != null) {
                bVar = k.b.aD(str6, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                aVar3.resetChatBubbleWidth(aVar3.clickArea, aVar3.PJa);
                aVar3.clickArea.setBackgroundResource(R.drawable.kl);
                aVar3.clickArea.setPadding(0, 0, 0, 0);
                aVar3.PLD.setSingleLine(true);
                aag aag = new aag();
                aag.ehb.dQp = bVar.ixQ;
                EventCenter.instance.publish(aag);
                boolean z = !aag.ehc.ehd;
                if (aag.ehc.status == -2) {
                    z = false;
                }
                int i3 = aag.ehc.status;
                if (i3 <= 0) {
                    i3 = bVar.ixN;
                }
                if (aVar3.qdl != null) {
                    if (ao.isDarkMode()) {
                        aVar3.PLC.setAlpha(0.8f);
                        aVar3.PLD.setAlpha(0.8f);
                        aVar3.PLE.setAlpha(0.8f);
                        aVar3.PLF.setAlpha(0.5f);
                    } else {
                        aVar3.PLC.setAlpha(1.0f);
                        aVar3.PLD.setAlpha(1.0f);
                        aVar3.PLE.setAlpha(1.0f);
                        aVar3.PLF.setAlpha(0.8f);
                    }
                    aVar3.qdl.setBackgroundResource(R.color.ac_);
                    aVar3.HMl.setVisibility(0);
                }
                switch (i3) {
                    case 1:
                    case 7:
                        j jVar = (j) bVar.as(j.class);
                        if (aVar2.gRM()) {
                            aVar3.PLD.setText(R.string.azf);
                        } else if (!af.isNullOrNil(bVar.iyX)) {
                            if (Util.isEqual(jVar.iwA, 1)) {
                                if (bVar.iyX.length() > 5) {
                                    str5 = bVar.iyX.substring(0, 5) + "..." + MMApplicationContext.getContext().getString(R.string.azi);
                                } else {
                                    str5 = bVar.iyX + aVar2.Pwc.getContext().getString(R.string.azi);
                                }
                                c2 = l.c(aVar2.Pwc.getContext(), str5);
                            } else {
                                c2 = l.c(aVar2.Pwc.getContext(), bVar.iyX);
                            }
                            aVar3.PLD.setText(c2);
                        } else if (Util.isEqual(jVar.iwA, 1)) {
                            aVar3.PLD.setText(MMApplicationContext.getContext().getString(R.string.azh) + MMApplicationContext.getContext().getString(R.string.azi));
                        } else {
                            aVar3.PLD.setText(R.string.azh);
                        }
                        aVar3.PLE.setText(bVar.ixO);
                        aVar3.PLC.setImageResource(R.raw.c2c_remittance_icon);
                        break;
                    case 2:
                        if (aVar2.gRM()) {
                            aVar3.PLD.setText(R.string.azo);
                        } else if (af.isNullOrNil(bVar.iyX)) {
                            aVar3.PLD.setText(R.string.azn);
                        } else {
                            aVar3.PLD.setText(MMApplicationContext.getContext().getString(R.string.azn) + "-" + bVar.iyX);
                        }
                        aVar3.PLE.setText(bVar.ixO);
                        aVar3.PLC.setImageResource(R.raw.c2c_remittance_icon);
                        a(aVar3);
                        break;
                    case 3:
                        if (aVar2.gRM()) {
                            aVar3.PLD.setText(R.string.az4);
                        } else if (z) {
                            if (Util.isEqual(((j) bVar.as(j.class)).iwA, 1)) {
                                if (af.isNullOrNil(bVar.iyX)) {
                                    str4 = MMApplicationContext.getContext().getString(R.string.az6) + MMApplicationContext.getContext().getString(R.string.azi);
                                } else {
                                    str4 = MMApplicationContext.getContext().getString(R.string.az6) + "-" + bVar.iyX;
                                    if (str4.length() > 5) {
                                        str4 = str4.substring(0, 5) + "..." + MMApplicationContext.getContext().getString(R.string.azi);
                                    }
                                }
                            } else if (af.isNullOrNil(bVar.iyX)) {
                                str4 = MMApplicationContext.getContext().getString(R.string.az6);
                            } else {
                                str4 = MMApplicationContext.getContext().getString(R.string.az6) + "-" + bVar.iyX;
                            }
                            aVar3.PLD.setText(l.c(aVar2.Pwc.getContext(), str4));
                        } else {
                            aVar3.PLD.setText(R.string.az7);
                        }
                        aVar3.PLE.setText(bVar.ixO);
                        aVar3.PLC.setImageResource(R.raw.c2c_remittance_received_icon);
                        a(aVar3);
                        break;
                    case 4:
                        if (aVar2.gRM()) {
                            aVar3.PLD.setText(R.string.azj);
                        } else if (z) {
                            if (af.isNullOrNil(bVar.iyX)) {
                                str3 = MMApplicationContext.getContext().getString(R.string.azl);
                            } else {
                                str3 = MMApplicationContext.getContext().getString(R.string.azl) + "-" + bVar.iyX;
                            }
                            aVar3.PLD.setText(l.c(aVar2.Pwc.getContext(), str3));
                        } else {
                            aVar3.PLD.setText(R.string.azk);
                        }
                        aVar3.PLE.setText(bVar.ixO);
                        aVar3.PLC.setImageResource(R.raw.c2c_remittance_cancle_icon);
                        a(aVar3);
                        break;
                    case 5:
                        if (aVar2.gRM()) {
                            aVar3.PLD.setText(R.string.aze);
                        } else if (z) {
                            if (af.isNullOrNil(bVar.iyX)) {
                                str2 = MMApplicationContext.getContext().getString(R.string.azc);
                            } else {
                                str2 = MMApplicationContext.getContext().getString(R.string.azc) + "-" + bVar.iyX;
                            }
                            aVar3.PLD.setText(l.c(aVar2.Pwc.getContext(), str2));
                        } else {
                            aVar3.PLD.setText(R.string.azd);
                        }
                        aVar3.PLE.setText(bVar.ixO);
                        aVar3.PLC.setImageResource(R.raw.c2c_remittance_received_icon);
                        a(aVar3);
                        break;
                    case 6:
                        if (af.isNullOrNil(bVar.iyX)) {
                            aVar3.PLD.setText(R.string.az8);
                        } else {
                            aVar3.PLD.setText(MMApplicationContext.getContext().getString(R.string.az8) + "-" + bVar.iyX);
                        }
                        aVar3.PLE.setText(bVar.ixO);
                        aVar3.PLC.setImageResource(R.raw.c2c_remittance_cancle_icon);
                        a(aVar3);
                        break;
                    default:
                        aVar3.PLC.setImageResource(R.raw.c2c_remittance_icon);
                        aVar3.PLD.setSingleLine(false);
                        aVar3.PLD.setMaxLines(2);
                        aVar3.PLE.setText((CharSequence) null);
                        aVar3.PLD.setText(bVar.description);
                        break;
                }
                aVar3.clickArea.setOnClickListener(d(aVar2));
                aVar3.clickArea.setOnLongClickListener(c(aVar2));
                aVar3.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
                aVar3.clickArea.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
            }
            AppMethodBeat.o(37045);
        }

        private static void a(a aVar) {
            AppMethodBeat.i(37046);
            aVar.clickArea.getPaddingLeft();
            aVar.clickArea.getPaddingTop();
            aVar.clickArea.getPaddingRight();
            aVar.clickArea.getPaddingBottom();
            aVar.clickArea.setBackgroundResource(R.drawable.km);
            aVar.clickArea.setPadding(0, 0, 0, 0);
            if (aVar.qdl != null) {
                if (ao.isDarkMode()) {
                    aVar.PLC.setAlpha(0.3f);
                    aVar.PLD.setAlpha(0.3f);
                    aVar.PLE.setAlpha(0.3f);
                    aVar.PLF.setAlpha(0.3f);
                } else {
                    aVar.PLC.setAlpha(1.0f);
                    aVar.PLD.setAlpha(1.0f);
                    aVar.PLE.setAlpha(1.0f);
                    aVar.PLF.setAlpha(0.8f);
                }
                aVar.qdl.setBackgroundResource(R.color.ac_);
                aVar.HMl.setVisibility(0);
            }
            AppMethodBeat.o(37046);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233791);
            int i2 = ((bq) view.getTag()).position;
            if (caVar != null) {
                mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            }
            AppMethodBeat.o(233791);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37048);
            menuItem.getItemId();
            AppMethodBeat.o(37048);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37049);
            if (!WeChatBrands.Business.Entries.SessionPayment.checkAvailable(view.getContext())) {
                AppMethodBeat.o(37049);
                return true;
            }
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (bVar != null) {
                Intent intent = new Intent();
                intent.putExtra("sender_name", caVar.field_talker);
                switch (bVar.ixN) {
                    case 1:
                    case 7:
                        intent.putExtra("invalid_time", bVar.ixR);
                        intent.putExtra("is_sender", false);
                        intent.putExtra("appmsg_type", bVar.ixN);
                        intent.putExtra("transfer_id", bVar.ixQ);
                        intent.putExtra(FirebaseAnalytics.b.TRANSACTION_ID, bVar.ixP);
                        intent.putExtra("effective_date", bVar.ixS);
                        intent.putExtra("total_fee", bVar.dYg);
                        intent.putExtra("fee_type", bVar.dFv);
                        if (!z.aUo()) {
                            com.tencent.mm.br.c.a(aVar.Pwc, "remittance", ".ui.RemittanceDetailUI", intent, (int) TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS);
                            break;
                        } else {
                            com.tencent.mm.br.c.a(aVar.Pwc, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent, (int) TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS);
                            break;
                        }
                    case 2:
                    default:
                        Log.w("MicroMsg.ChattingItemAppMsgRemittanceFrom", "Unrecognized type %d, probably version to low & check update!", Integer.valueOf(bVar.ixN));
                        af.dA(aVar.Pwc.getContext());
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        intent.putExtra("is_sender", true);
                        intent.putExtra("appmsg_type", bVar.ixN);
                        intent.putExtra("transfer_id", bVar.ixQ);
                        intent.putExtra(FirebaseAnalytics.b.TRANSACTION_ID, bVar.ixP);
                        intent.putExtra("effective_date", bVar.ixS);
                        intent.putExtra("total_fee", bVar.dYg);
                        intent.putExtra("fee_type", bVar.dFv);
                        if (!z.aUo()) {
                            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "remittance", ".ui.RemittanceDetailUI", intent);
                            break;
                        } else {
                            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent);
                            break;
                        }
                }
                AppMethodBeat.o(37049);
                return true;
            }
            AppMethodBeat.o(37049);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends c.a {
        public ImageView HMl;
        public int PJa = 0;
        public ImageView PLC;
        public TextView PLD;
        public TextView PLE;
        public TextView PLF;
        public View qdl;

        a() {
        }

        public final a gZ(View view) {
            AppMethodBeat.i(37043);
            super.create(view);
            this.timeTV = (TextView) this.convertView.findViewById(R.id.ayf);
            this.checkBox = (CheckBox) this.convertView.findViewById(R.id.aue);
            this.maskView = this.convertView.findViewById(R.id.ax3);
            this.userTV = (TextView) this.convertView.findViewById(R.id.ayn);
            this.qdl = this.convertView.findViewById(R.id.d8b);
            this.HMl = (ImageView) this.convertView.findViewById(R.id.brt);
            this.PLF = (TextView) this.convertView.findViewById(R.id.ud);
            this.PLC = (ImageView) this.convertView.findViewById(R.id.uc);
            this.PLD = (TextView) this.convertView.findViewById(R.id.ue);
            this.PLE = (TextView) this.convertView.findViewById(R.id.ub);
            this.PJa = c.kl(MMApplicationContext.getContext());
            this.PLE.setTypeface(((com.tencent.mm.pluginsdk.wallet.b) g.af(com.tencent.mm.pluginsdk.wallet.b.class)).gA(this.convertView.getContext()));
            AppMethodBeat.o(37043);
            return this;
        }
    }
}
