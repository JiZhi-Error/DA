package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;

final class g extends Filter {
    a Tv;

    interface a {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    g(a aVar) {
        this.Tv = aVar;
    }

    public final CharSequence convertResultToString(Object obj) {
        return this.Tv.convertToString((Cursor) obj);
    }

    /* access modifiers changed from: protected */
    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor runQueryOnBackgroundThread = this.Tv.runQueryOnBackgroundThread(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (runQueryOnBackgroundThread != null) {
            filterResults.count = runQueryOnBackgroundThread.getCount();
            filterResults.values = runQueryOnBackgroundThread;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    /* access modifiers changed from: protected */
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursor = this.Tv.getCursor();
        if (filterResults.values != null && filterResults.values != cursor) {
            this.Tv.changeCursor((Cursor) filterResults.values);
        }
    }
}
