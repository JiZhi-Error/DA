package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.c.b;
import io.flutter.plugin.b.c;
import java.util.HashMap;

public final class a {
    private final b SMo;
    private final c SMp;
    private int SMq;

    public a(b bVar, c cVar) {
        this.SMo = bVar;
        this.SMp = cVar;
    }

    public final void j(KeyEvent keyEvent) {
        AppMethodBeat.i(10055);
        Character atm = atm(keyEvent.getUnicodeChar());
        b bVar = this.SMo;
        b.a aVar = new b.a(keyEvent, atm);
        HashMap hashMap = new HashMap();
        hashMap.put("type", "keyup");
        hashMap.put("keymap", "android");
        b.a(aVar, hashMap);
        bVar.SPQ.eN(hashMap);
        AppMethodBeat.o(10055);
    }

    public final void k(KeyEvent keyEvent) {
        AppMethodBeat.i(10056);
        if (this.SMp.SSL != null && this.SMp.SSy.isAcceptingText()) {
            this.SMp.SSL.sendKeyEvent(keyEvent);
        }
        Character atm = atm(keyEvent.getUnicodeChar());
        b bVar = this.SMo;
        b.a aVar = new b.a(keyEvent, atm);
        HashMap hashMap = new HashMap();
        hashMap.put("type", "keydown");
        hashMap.put("keymap", "android");
        b.a(aVar, hashMap);
        bVar.SPQ.eN(hashMap);
        AppMethodBeat.o(10056);
    }

    private Character atm(int i2) {
        AppMethodBeat.i(10057);
        if (i2 == 0) {
            AppMethodBeat.o(10057);
            return null;
        }
        Character valueOf = Character.valueOf((char) i2);
        if ((Integer.MIN_VALUE & i2) != 0) {
            int i3 = Integer.MAX_VALUE & i2;
            if (this.SMq != 0) {
                this.SMq = KeyCharacterMap.getDeadChar(this.SMq, i3);
            } else {
                this.SMq = i3;
            }
        } else if (this.SMq != 0) {
            int deadChar = KeyCharacterMap.getDeadChar(this.SMq, i2);
            if (deadChar > 0) {
                valueOf = Character.valueOf((char) deadChar);
            }
            this.SMq = 0;
        }
        AppMethodBeat.o(10057);
        return valueOf;
    }
}
