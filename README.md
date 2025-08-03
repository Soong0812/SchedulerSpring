#일정관리 API (Scheduler)

Spring Boot 기반의 일정 관리 (Scehduler) API입니다. 

일정을 등록하고(패스워드 포함), 목록을 조회하고(전체or단건, 패스워드 미출력), 

일정 등록 후에도 비밀번호를 입력해 일정 수정/삭제가 가능합니다.

--------------------------------------------------------------------------------------------------

##API 명세

###1. 일정 등록
1) 요청
-URL : POST /schedules
```json     
{     
  "title": "회의",     
  "content": "팀 회의 내용 정리",    
  "writer": "홍길동",     
  "password": "1234"
}
```     
2) 응답
```json
{
  "id": 1,
  "title": "회의",
  "content": "팀 회의 내용 정리",
  "username": "홍길동",
  "createdAt": "2025-08-04T10:00:00",
  "updatedAt": "2025-08-04T10:00:00"
}
```

###2. 목록 조회
1) 전체 조회
-URL : GET /schedules
```json
{
  "id": 1,
  "title": "회의",
  "content": "팀 회의 내용 정리",
  "username": "홍길동",
  "createdAt": "2025-08-04T10:00:00",
  "updatedAt": "2025-08-04T10:00:00"
},

{
  "id": 2,
  "title": "회의",
  "content": "팀 회의 내용 수정",
  "username": "임꺽정",
  "createdAt": "2025-08-04T14:00:00",
  "updatedAt": "2025-08-04T14:00:00"
}
```
2) 단일 조회
-URL : GET /schedules/{scheduleId}
-Id값 1로 조회한 경우
```json
{
  "id": 1,
  "title": "회의",
  "content": "팀 회의 내용 정리",
  "username": "홍길동",
  "createdAt": "2025-08-04T10:00:00",
  "updatedAt": "2025-08-04T10:00:00"
}
```

###3. 일정 수정
-URL : PUT /schedules/{scheduleId}
-Id값 1을 수정할 경우
```json
}
  "title": "회의 변경",
  "content": "회의 시간 변경됨",
  "writer" : "홍길동"
  "password": "1234"
}

{
  "id": 1,
  "title": "회의 변경",
  "content": "회의 시간 변경됨",
  "username": "홍길동",
  "createdAt": "2025-08-04T10:00:00",
  "updatedAt": "2025-08-04T14:00:00"
}
```

###4. 일정 삭제
-URL : DELETE /schedules/{scheduleId}
```json
{
  "title": null,
  "content": null,
  "writer": null,
  "password": "1234"
}
```

###5. 기타
-ID값이 없으면 "해당 일정이 없습니다." 출력
-Password가 틀리면 "비밀번호가 틀렸습니다." 출력

