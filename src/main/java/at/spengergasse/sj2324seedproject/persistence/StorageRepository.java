package at.spengergasse.sj2324seedproject.persistence;

import at.spengergasse.sj2324seedproject.domain.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageRepository extends JpaRepository <Storage, Long> {
    //Cursor auf StorageRepository -- Tastenkürzel STrg + shift + t ---- Create New test




}
