package com.example.app_nhac.Notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.app_nhac.R;
import com.example.app_nhac.Service.NotificationActionService;
import com.example.app_nhac.model.AudioModel;

import com.example.app_nhac.Service.NotificationActionService;

public class CreateMediaNotification {
    public static final String CHANNEL_ID = "channel1";

    public static final String ACTION_PREVIUOS = "actionprevious";
    public static final String ACTION_PLAY = "actionplay";
    public static final String ACTION_NEXT = "actionnext";

    public static Notification notification;
    public static void createNotification(Context context, AudioModel track, int playbutton, int pos, int size){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
            MediaSessionCompat mediaSessionCompat = new MediaSessionCompat( context, "tag");
            Bitmap defaultIcon = BitmapFactory.decodeResource(context.getResources(), R.drawable.music_icon_big);
            Bitmap icon = null;
            if (track.getImage() != null && track.getImage().length > 0) {
                icon = BitmapFactory.decodeByteArray(track.getImage(), 0, track.getImage().length);
            }
            Bitmap largeIconBitmap = icon != null ? icon : defaultIcon;
            PendingIntent pendingIntentPrevious;
            int drw_previous;
            Intent intentPrevious = new Intent(context, NotificationActionService.class)
                    .setAction(ACTION_PREVIUOS);
            pendingIntentPrevious = PendingIntent.getBroadcast(context, 0,
                    intentPrevious, PendingIntent.FLAG_MUTABLE);
            drw_previous = R.drawable.ic_baseline_skip_previous_24;

            Intent intentPlay = new Intent(context, NotificationActionService.class)
                    .setAction(ACTION_PLAY);
            PendingIntent pendingIntentPlay = PendingIntent.getBroadcast(context, 0,
                    intentPlay, PendingIntent.FLAG_MUTABLE);

            PendingIntent pendingIntentNext;
            int drw_next;
            Intent intentNext = new Intent(context, NotificationActionService.class)
                    .setAction(ACTION_NEXT);
            pendingIntentNext = PendingIntent.getBroadcast(context, 0,
                    intentNext, PendingIntent.FLAG_MUTABLE);
            drw_next = R.drawable.ic_baseline_skip_next_24;

            //create notification
            notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                    .setSmallIcon(R.drawable.music_icon)
                    .setContentTitle(track.getTitle())
                    .setContentText(track.getTitle())
                    .setLargeIcon(largeIconBitmap)
                    .setOnlyAlertOnce(true)//show notification for only first time
                    .setShowWhen(false)
                    .addAction(drw_previous, "Previous", pendingIntentPrevious)
                    .addAction(playbutton, "Play", pendingIntentPlay)
                    .addAction(drw_next, "Next", pendingIntentNext)
                    .setStyle(new androidx.media.app.NotificationCompat.MediaStyle()
                            .setShowActionsInCompactView(0, 1, 2)
                            .setMediaSession(mediaSessionCompat.getSessionToken()))
                    .setPriority(NotificationCompat.PRIORITY_LOW)
                    .build();

            notificationManagerCompat.notify(1, notification);

        }
    }

}

