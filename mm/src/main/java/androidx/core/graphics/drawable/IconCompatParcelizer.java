package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import android.support.v4.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.charset.Charset;

public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        AppMethodBeat.i(62496);
        IconCompat iconCompat = new IconCompat();
        iconCompat.mType = aVar.aN(iconCompat.mType, 1);
        iconCompat.mData = aVar.j(iconCompat.mData);
        iconCompat.Ko = aVar.a(iconCompat.Ko, 3);
        iconCompat.Kp = aVar.aN(iconCompat.Kp, 4);
        iconCompat.Kq = aVar.aN(iconCompat.Kq, 5);
        iconCompat.Kr = (ColorStateList) aVar.a(iconCompat.Kr, 6);
        iconCompat.Ks = aVar.N(iconCompat.Ks);
        iconCompat.yl = PorterDuff.Mode.valueOf(iconCompat.Ks);
        switch (iconCompat.mType) {
            case -1:
                if (iconCompat.Ko != null) {
                    iconCompat.Kn = iconCompat.Ko;
                    break;
                } else {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid icon");
                    AppMethodBeat.o(62496);
                    throw illegalArgumentException;
                }
            case 1:
            case 5:
                if (iconCompat.Ko == null) {
                    iconCompat.Kn = iconCompat.mData;
                    iconCompat.mType = 3;
                    iconCompat.Kp = 0;
                    iconCompat.Kq = iconCompat.mData.length;
                    break;
                } else {
                    iconCompat.Kn = iconCompat.Ko;
                    break;
                }
            case 2:
            case 4:
                iconCompat.Kn = new String(iconCompat.mData, Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.Kn = iconCompat.mData;
                break;
        }
        AppMethodBeat.o(62496);
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        AppMethodBeat.i(62497);
        iconCompat.Ks = iconCompat.yl.name();
        switch (iconCompat.mType) {
            case -1:
                iconCompat.Ko = (Parcelable) iconCompat.Kn;
                break;
            case 1:
            case 5:
                iconCompat.Ko = (Parcelable) iconCompat.Kn;
                break;
            case 2:
                iconCompat.mData = ((String) iconCompat.Kn).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.mData = (byte[]) iconCompat.Kn;
                break;
            case 4:
                iconCompat.mData = iconCompat.Kn.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        aVar.aM(iconCompat.mType, 1);
        aVar.i(iconCompat.mData);
        aVar.writeParcelable(iconCompat.Ko, 3);
        aVar.aM(iconCompat.Kp, 4);
        aVar.aM(iconCompat.Kq, 5);
        aVar.writeParcelable(iconCompat.Kr, 6);
        aVar.M(iconCompat.Ks);
        AppMethodBeat.o(62497);
    }
}
