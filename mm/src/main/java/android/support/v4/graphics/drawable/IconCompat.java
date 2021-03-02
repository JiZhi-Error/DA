package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.lang.reflect.InvocationTargetException;

public class IconCompat extends CustomVersionedParcelable {
    static final PorterDuff.Mode xl = PorterDuff.Mode.SRC_IN;
    public Object Kn;
    public Parcelable Ko;
    public int Kp;
    public int Kq;
    public ColorStateList Kr = null;
    public String Ks;
    public byte[] mData;
    public int mType;
    public PorterDuff.Mode yl = xl;

    public String toString() {
        String str;
        String str2;
        int i2;
        if (this.mType == -1) {
            return String.valueOf(this.Kn);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.mType) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        StringBuilder append = sb.append(str);
        switch (this.mType) {
            case 1:
            case 5:
                append.append(" size=").append(((Bitmap) this.Kn).getWidth()).append("x").append(((Bitmap) this.Kn).getHeight());
                break;
            case 2:
                StringBuilder append2 = append.append(" pkg=");
                if (this.mType == -1 && Build.VERSION.SDK_INT >= 23) {
                    str2 = a((Icon) this.Kn);
                } else if (this.mType != 2) {
                    throw new IllegalStateException("called getResPackage() on ".concat(String.valueOf(this)));
                } else {
                    str2 = ((String) this.Kn).split(":", -1)[0];
                }
                StringBuilder append3 = append2.append(str2).append(" id=");
                Object[] objArr = new Object[1];
                if (this.mType == -1 && Build.VERSION.SDK_INT >= 23) {
                    i2 = b((Icon) this.Kn);
                } else if (this.mType != 2) {
                    throw new IllegalStateException("called getResId() on ".concat(String.valueOf(this)));
                } else {
                    i2 = this.Kp;
                }
                objArr[0] = Integer.valueOf(i2);
                append3.append(String.format("0x%08x", objArr));
                break;
            case 3:
                append.append(" len=").append(this.Kp);
                if (this.Kq != 0) {
                    append.append(" off=").append(this.Kq);
                    break;
                }
                break;
            case 4:
                append.append(" uri=").append(this.Kn);
                break;
        }
        if (this.Kr != null) {
            append.append(" tint=");
            append.append(this.Kr);
        }
        if (this.yl != xl) {
            append.append(" mode=").append(this.yl);
        }
        append.append(")");
        return append.toString();
    }

    private static String a(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            return null;
        } catch (InvocationTargetException e3) {
            return null;
        } catch (NoSuchMethodException e4) {
            return null;
        }
    }

    private static int b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            return 0;
        } catch (InvocationTargetException e3) {
            return 0;
        } catch (NoSuchMethodException e4) {
            return 0;
        }
    }
}
