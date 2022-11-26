package com.example.kiosk.dao;


// mybatis interface mapper (SQL 명령어가 포함된 코드)

//인터페이스에는 원래 미완성된 코드 (추상메소드)만 넣을 수 있으나 여기에서는
//sql쿼리 어노테이션을 붙여서 추상메소드를 실행하면 위에 있는 sql쿼리가 실행이 된다.
//아까 애플리케이션.java파일에서 MapperScan 어노테이션을 사용해서
//("com.example.spring03_boot.model")경로에 있는 mapper을 사용할 수 있도록 설정해놓았기 때문에
// 여기 있는 sql쿼리를 바로 사용할 수 있는 것이다.

//그리고 여기에서 다 구현을 하고 있기 때문에 따로 DAOImpl (인터페이스 구현 클래스)를 만들필요가 없다.

import com.example.kiosk.dto.MenuDTO;

public interface MenuDAO {
    //일단 남에꺼 가져와서 보는용
//    @Select("select * from guestbook order by idx desc") // 게시글번호의 내림차순으로 방명록의 모든 요소를 검색
//    public List<MenuDTO> list();
//
//    // sql문이 여러줄 있을 경우에는 따움표나 쉼표나 띄어쓰기를 주의해서 사용한다.
//
//    @Insert("insert into guestbook " // 게시글 생성 (글번호 다음꺼, 이름, 이메일, 비밀번호, 내용)
//            + "(idx,name,email,passwd,content)" + " values " + "(guestbook_seq.nextval, #{name}, #{email}"
//            + ", #{passwd},#{content})")
//    public void insert(MenuDTO dto);
//
//    @Select("select * from guestbook where idx=#{idx}") // 해당 게시글번호에 맞는 게시글의 모든 요소를 검색
//    public MenuDTO view(int idx);
//
//    @Update("update guestbook set " + " name=#{name}, email=#{email}, content=#{content}" + " where idx=#{idx}")
//    // 글번호에 맞는 게시글의 정보 (이름, 이메일, 내용)을 수정함
//
//
//    public void update(MenuDTO dto);
//
//    @Delete("delete from guestbook where idx=#{idx}") // 게시글 번호에 맞는 게시글을 삭제함
//    public void delete(int idx);

}

