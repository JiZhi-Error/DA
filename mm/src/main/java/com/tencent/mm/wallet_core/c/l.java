package com.tencent.mm.wallet_core.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.protocal.protobuf.aae;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.dmp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.f;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class l {

    public interface a<InputType> {
        void dP(InputType inputtype);

        void eNp();

        int eNq();

        void eNr();

        void eNs();

        void eNw();
    }

    public static String b(cfl cfl) {
        AppMethodBeat.i(72749);
        if (cfl == null) {
            AppMethodBeat.o(72749);
            return "JumpItem{null}";
        }
        String str = "JumpItem{wording='" + cfl.dQx + '\'' + ", action=" + cfl.action + ", url='" + cfl.url + '\'' + ", username='" + cfl.username + '\'' + ", pagepath='" + cfl.Cqk + '\'' + '}';
        AppMethodBeat.o(72749);
        return str;
    }

    public static String bO(LinkedList<cfl> linkedList) {
        AppMethodBeat.i(72750);
        if (linkedList == null) {
            AppMethodBeat.o(72750);
            return "LinkedList<JumpItem>{null}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList<JumpItem>{");
        Iterator<cfl> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(b(it.next())).append(", ");
        }
        sb.append("}");
        String sb2 = sb.toString();
        AppMethodBeat.o(72750);
        return sb2;
    }

    public static JSONObject c(cfl cfl) {
        AppMethodBeat.i(72751);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wording", cfl.dQx);
            jSONObject.put(NativeProtocol.WEB_DIALOG_ACTION, cfl.action);
            jSONObject.put("url", cfl.url);
            jSONObject.put(ch.COL_USERNAME, cfl.username);
            jSONObject.put("pagepath", cfl.Cqk);
        } catch (JSONException e2) {
            Log.e("MicroMsg.JumpItemUtil", "getJSONObject() Exception: %s", e2.getMessage());
        }
        AppMethodBeat.o(72751);
        return jSONObject;
    }

    public static cfl bpm(String str) {
        AppMethodBeat.i(72752);
        try {
            cfl ci = ci(new JSONObject(str));
            AppMethodBeat.o(72752);
            return ci;
        } catch (JSONException e2) {
            Log.e("MicroMsg.JumpItemUtil", "createFromJSONObject() Exception:%s", e2.getMessage());
            AppMethodBeat.o(72752);
            return null;
        }
    }

    public static cfl ci(JSONObject jSONObject) {
        AppMethodBeat.i(72753);
        if (jSONObject == null) {
            Log.w("MicroMsg.JumpItemUtil", "createFromJSONObject() jsonObject == null");
            AppMethodBeat.o(72753);
            return null;
        }
        cfl cfl = new cfl();
        cfl.dQx = jSONObject.optString("wording");
        cfl.action = jSONObject.optInt(NativeProtocol.WEB_DIALOG_ACTION);
        cfl.url = jSONObject.optString("url");
        cfl.username = jSONObject.optString(ch.COL_USERNAME);
        cfl.Cqk = jSONObject.optString("pagepath");
        AppMethodBeat.o(72753);
        return cfl;
    }

    public static <InputType> void a(Context context, cfl cfl, InputType inputtype, a<InputType> aVar) {
        AppMethodBeat.i(72754);
        Object[] objArr = new Object[2];
        objArr[0] = cfl == null ? b(cfl) : BuildConfig.COMMAND;
        objArr[1] = aVar == null ? BuildConfig.COMMAND : "no null";
        Log.i("MicroMsg.JumpItemUtil", "handleAction() jumpItem:%s iJumpItemCallback:%s", objArr);
        if (cfl == null) {
            AppMethodBeat.o(72754);
            return;
        }
        switch (cfl.action) {
            case 0:
                if (aVar != null) {
                    aVar.eNp();
                    break;
                }
                break;
            case 1:
                if (aVar != null) {
                    aVar.eNw();
                    break;
                }
                break;
            case 2:
                if (aVar != null) {
                    aVar.dP(inputtype);
                    break;
                }
                break;
            case 3:
                Intent intent = new Intent();
                intent.putExtra("rawUrl", cfl.url);
                f.aA(context, intent);
                break;
            case 4:
                try {
                    wq wqVar = new wq();
                    wqVar.ecI.userName = cfl.username;
                    wqVar.ecI.ecK = cfl.Cqk;
                    if (aVar != null) {
                        wqVar.ecI.scene = aVar.eNq();
                    } else {
                        wqVar.ecI.scene = 1000;
                    }
                    wqVar.ecI.ecL = 0;
                    wqVar.ecI.context = context;
                    EventCenter.instance.publish(wqVar);
                    break;
                } catch (Exception e2) {
                    Log.e("MicroMsg.JumpItemUtil", "handleAction() Exception: %s", e2.getMessage());
                    break;
                }
            case 5:
                if (aVar != null) {
                    aVar.eNs();
                    break;
                }
                break;
        }
        if (aVar != null) {
            aVar.eNr();
        }
        AppMethodBeat.o(72754);
    }

    public static <InputType> void a(final Context context, final dmp dmp, final InputType inputtype, final a<InputType> aVar) {
        AppMethodBeat.i(72755);
        if (dmp == null) {
            Log.i("MicroMsg.JumpItemUtil", "showRemindWin() remindWin == null");
            AppMethodBeat.o(72755);
            return;
        }
        h.a(context, dmp.dQx, "", dmp.IoM.dQx, context.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.wallet_core.c.l.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(72743);
                Log.i("MicroMsg.JumpItemUtil", "showRemindWin() ok click!");
                l.a(context, dmp.IoM, inputtype, aVar);
                AppMethodBeat.o(72743);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.wallet_core.c.l.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(72744);
                Log.i("MicroMsg.JumpItemUtil", "showRemindWin() cancel click!");
                AppMethodBeat.o(72744);
            }
        }).show();
        AppMethodBeat.o(72755);
    }

    public static <InputType> void a(final Context context, final aae aae, final InputType inputtype, final a<InputType> aVar, final a aVar2) {
        AppMethodBeat.i(72756);
        if (aae == null) {
            Log.i("MicroMsg.JumpItemUtil", "showCheckWin() checkWin == null");
            AppMethodBeat.o(72756);
        } else if (aae.IoL == null || aae.IoM == null) {
            Log.i("MicroMsg.JumpItemUtil", "showCheckWin() left_button == null || right_button == null");
            AppMethodBeat.o(72756);
        } else if (aae.Llq == null || aae.Llq.isEmpty()) {
            Log.i("MicroMsg.JumpItemUtil", "showCheckWin() check_item == null || check_item.isEmpty()");
            AppMethodBeat.o(72756);
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.u_, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.idt)).setText(aae.subtitle);
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.e22);
            for (int i2 = 0; i2 < aae.Llq.size(); i2++) {
                View inflate2 = LayoutInflater.from(context).inflate(R.layout.u9, (ViewGroup) null);
                ((TextView) inflate2.findViewById(R.id.e2l)).setText(aae.Llq.get(i2).key);
                ((TextView) inflate2.findViewById(R.id.e43)).setText(aae.Llq.get(i2).value);
                linearLayout.addView(inflate2);
            }
            h.a(context, false, aae.title, inflate, aae.IoM.dQx, aae.IoL.dQx, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.wallet_core.c.l.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(72745);
                    Log.i("MicroMsg.JumpItemUtil", "showCheckWin() right_button click!");
                    l.a(context, aae.IoM, inputtype, aVar2);
                    AppMethodBeat.o(72745);
                }
            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.wallet_core.c.l.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(72746);
                    Log.i("MicroMsg.JumpItemUtil", "showCheckWin() left_button click!");
                    l.a(context, aae.IoL, inputtype, aVar);
                    AppMethodBeat.o(72746);
                }
            }).show();
            AppMethodBeat.o(72756);
        }
    }
}
