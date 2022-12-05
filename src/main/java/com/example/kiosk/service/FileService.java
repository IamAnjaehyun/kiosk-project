package com.example.kiosk.service;

import com.example.kiosk.domain.File;
import com.example.kiosk.domain.Menu;
import com.example.kiosk.domain.Repository.FileRepository;
import com.example.kiosk.dto.FileDto;
import com.example.kiosk.dto.MenuDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    private FileRepository fileRepository;

    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Transactional
    public Long saveFile(FileDto fileDto) {
        return fileRepository.save(fileDto.toEntity()).getId();
    }

    @Transactional
    public FileDto getFile(Long id) {
        File file = fileRepository.findById(id).get();

        FileDto fileDto = FileDto.builder()
                .id(id)
                .origFilename(file.getOrigFilename())
                .filename(file.getFilename())
                .filePath(file.getFilePath())
                .build();
        return fileDto;
    }

    @Transactional
    public List<FileDto> getFilelist(){
        List<File> files = fileRepository.findAll();
        List<FileDto> fileDtoList = new ArrayList<>();

        for(File file : files){
            FileDto fileDto = FileDto.builder()
                    .id(file.getId())
                    .origFilename(file.getOrigFilename())
                    .filePath(file.getFilePath())
                    .filename(file.getFilename())
                    .build();

            fileDtoList.add(fileDto);
        }
        return fileDtoList;
    }
}