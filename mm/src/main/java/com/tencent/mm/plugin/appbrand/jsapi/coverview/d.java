package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    private static int action = 0;
    private static int eventId = 0;
    private static long hET = 0;
    private static long lTl = 0;

    public static void a(h hVar, int i2, MotionEvent motionEvent, String str, boolean z) {
        AppMethodBeat.i(193664);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float x = motionEvent.getX(actionIndex);
        float y = motionEvent.getY(actionIndex);
        if (action == motionEvent.getAction() && eventId == pointerId && lTl == motionEvent.getEventTime() && hET == motionEvent.getDownTime()) {
            Log.i("MicroMsg.InsertViewTouchEventDispatch", "action:%d, eventId:%d, eventTime:%d, downTime:%d, don't send Duplicate event", Integer.valueOf(motionEvent.getAction()), Integer.valueOf(pointerId), Long.valueOf(motionEvent.getEventTime()), Long.valueOf(motionEvent.getDownTime()));
            AppMethodBeat.o(193664);
            return;
        }
        action = motionEvent.getAction();
        eventId = pointerId;
        lTl = motionEvent.getEventTime();
        hET = motionEvent.getDownTime();
        e.f fVar = new e.f();
        fVar.b(pointerId, x, y);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", str);
            jSONObject.put("viewId", i2);
        } catch (JSONException e2) {
        }
        Log.i("MicroMsg.InsertViewTouchEventDispatch", "action:%d, eventId:%d, eventTime:%d, downTime:%d", Integer.valueOf(motionEvent.getAction()), Integer.valueOf(pointerId), Long.valueOf(lTl), Long.valueOf(hET));
        bc bcVar = null;
        switch (motionEvent.getAction()) {
            case 0:
                try {
                    jSONObject.put("touch", fVar.toJSONObject());
                } catch (JSONException e3) {
                }
                bcVar = new e.c();
                break;
            case 1:
                try {
                    jSONObject.put("touch", fVar.toJSONObject());
                } catch (JSONException e4) {
                }
                bcVar = new e.C0599e();
                break;
            case 2:
                JSONArray jSONArray = new JSONArray();
                try {
                    jSONObject.put("touches", jSONArray);
                } catch (JSONException e5) {
                }
                e.f[] z2 = z(motionEvent);
                if (z2.length > 0) {
                    for (e.f fVar2 : z2) {
                        jSONArray.put(fVar2.toJSONObject());
                    }
                }
                bcVar = new e.d();
                break;
            case 3:
                JSONArray jSONArray2 = new JSONArray();
                try {
                    jSONObject.put("touches", jSONArray2);
                } catch (JSONException e6) {
                }
                e.f[] z3 = z(motionEvent);
                if (z3.length > 0) {
                    for (e.f fVar3 : z3) {
                        jSONArray2.put(fVar3.toJSONObject());
                    }
                }
                bcVar = new e.b();
                break;
        }
        if (bcVar == null || !z) {
            if (bcVar != null) {
                bcVar.Zh(jSONObject.toString());
                hVar.a(bcVar, (int[]) null);
            }
            AppMethodBeat.o(193664);
            return;
        }
        bcVar.Zh(jSONObject.toString());
        hVar.a(bcVar);
        AppMethodBeat.o(193664);
    }

    private static e.f[] z(MotionEvent motionEvent) {
        AppMethodBeat.i(137517);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < motionEvent.getPointerCount(); i2++) {
            e.f fVar = new e.f();
            fVar.id = motionEvent.getPointerId(i2);
            fVar.x = motionEvent.getX(i2);
            fVar.y = motionEvent.getY(i2);
            arrayList.add(fVar);
        }
        e.f[] fVarArr = new e.f[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            fVarArr[i3] = (e.f) arrayList.get(i3);
        }
        AppMethodBeat.o(137517);
        return fVarArr;
    }
}
