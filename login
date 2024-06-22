<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LuxCinema - Home</title>



    <style main home>    /* 메인홈 스타일 */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        header {
            background-color: #333;
            color: white;
            padding: 20px 0;
            text-align: center;
        }
        header h1 {
            margin: 0;
        }
        nav {
            display: flex;
            justify-content: center;
            background-color: #444;
        }
        nav a {
            color: white;
            padding: 14px 20px;
            text-decoration: none;
            text-align: center;
        }
        h1 {
            display: inline-block;
        }
        nav a:hover {
            background-color: #555;
        }
        .main-content {
            padding: 20px;
        }
        .movie-list {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }
        .movie {
            background-color: white;
            border: 1px solid #ddd;
            border-radius: 8px;
            margin: 10px;
            width: 200px;
            text-align: center;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .movie img {
            width: 100%;
            border-bottom: 1px solid #ddd;
        }
        .movie h3 {
            padding: 10px 0;
        }
        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px 0;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
        fieldset {
            display: inline-block; /* 필드셋을 인라인 블록 요소로 설정 */
            width: 200px;
            margin-left: 35px;
            background-color: white; /* 배경색을 흰색으로 설정 */
            padding: 20px; /* 필요한 경우 여백 추가 */
            border-radius: 10px; /* 테두리의 모서리를 10px 둥글게 설정 */
        }
        .video-container {
            display: flex;
            justify-content: center; /* 가로 중앙 정렬 */
            align-items: center;    /* 세로 중앙 정렬 */
        }
    </style>

    <style login>      /* 로그인 스타일 */
  .container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 50vh; /* 화면 전체 높이로 설정 */
}

.form-container {
    width: 350px; /* 폼 컨테이너 너비 */
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-container h2 {
    text-align: center;
    margin-bottom: 20px;
}

#login-form {
    display: flex;
    flex-direction: column;
}

.login_id,
.login_password {
    margin-bottom: 15px;
}

.login_id label,
.login_password label {
    display: block;
    margin-bottom: 5px;
}

.login_id input,
.login_password input,
.logein_button button {
    width: 90%; /* 부모 너비에 맞게 설정 */
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

.logein_button {
    text-align: center;
}

    </style>








    <a href="member.html" style="position: absolute; top: 10px; right: 10px; font-size: 12px; color:white">관리자페이지로 넘어가기</a>
</head>
<body>

<header>
    <a href="home.html"><h1 style="color :white">LuxCinema</h1> </a>
</header>

<nav>
    <a href="movieList.html">영화 목록</a>
    <a href="#">극장 선택</a>
    <a href="#">예매</a>
    <a href="login.html">로그인</a>
    <a href="logup.html">회원가입</a>
</nav>

<div class="container">
    <div class="form-container">
        <h2>로그인</h2>
        <form id="login-form">
            <div class="login_id">
                <label for="username">아이디</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="login_password">
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="logein_button">
                <button type="submit">로그인</button>
            </div>
        </form>
    </div>
</div>
<br><br><br><br><br> <hr> <br><br>

<span style="margin-left: 80px;"></span>
<fieldset style="width: 550px;">
    <span style="font-size: 20px; font-weight:bold;">공지사항</span> <span style="color: #6E6E6E; margin-left: 30px;"> 스파이더맨 한정판 피규어의 판매가 종료될 수 있습니다.</span><br>
    <hr>
    <span style="font-size: 20px; font-weight:bold;">고객센터</span> <span style="font-size: 20px; margin-left: 30px;">051-200-6212</span><br>
    <span style="color: #6E6E6E; margin-left: 112px;">고객센터 운영시간 (평일 09:00~18:00)</span><br>
    <span style="color: #6E6E6E; margin-left: 112px;">업무시간 외 자동응답 안내 가능합니다.</span>
</fieldset>

<br><br><br><br><br>
<footer>
    <p>&copy; 2024 LuxCinema. All rights reserved.</p>
</footer>

</body>
</html>
