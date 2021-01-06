package com.example.localfeeds.activities;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class FireStoreService {

    private static final String TAG = "FireStoreService";
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    FireStoreService() {

    }

    void addAnnouncement(String productor, String desc) {
        Map<String, Object> announcement = new HashMap<>();
        announcement.put("idProductor", productor);
        announcement.put("desc", desc);
        Timestamp now = Timestamp.now();
        announcement.put("date", now);

        db.collection("announcements")
                .add(announcement)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }

    Task<QuerySnapshot> getAnnouncements() {
        return db.collection("announcements").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    Task<DocumentSnapshot> getAnnouncement(String id) {
        return db.collection("announcements").document(id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

    void modifyAnnouncement(String id, String mess) {
        db.collection("announcements").document(id).update("desc", mess);
    }

    void deleteAnnouncement(String id){
       db.collection("announcements").document(id).delete();
    }

    Task<QuerySnapshot> getAnnouncementByProductor(String idProductor) {
        return db.collection("announcements")
                .whereEqualTo("idProductor", idProductor)
                .get();
    }

}
