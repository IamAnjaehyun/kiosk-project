package com.example.kiosk.domain.Repository;

import com.example.kiosk.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {}