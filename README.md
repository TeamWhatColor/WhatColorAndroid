# WhatColorAndroid 

### :star: 2차 과제


## 구현영상 GIF

<img src="https://user-images.githubusercontent.com/49150980/142743623-fee9a1ec-c389-4d28-a357-c78bdad5ac38.gif" width="40%">  

# :white_check_mark: 서비스 이름과 간단한 서비스 소개
## 서비스 이름
* 너 무슨 색이야?!
## 간단한 서비스 소개
* 색깔로 정해지는 N개의 팀! 미션을 통해 컬러 메이트를 찾아라!

# :white_check_mark: 각자 개발 담당 부분
## 이강민
* 스플래시 레이아웃 및 기능 구현
* 스플래시에서 기기 고유값으로 서버 통신 및 식별
* 유저입력 레이아웃 및 기능 구현
* '팀 배정 완료' 레이아웃 및 기능 구현, 서버통신
* 팝업 기능 구현
* yb의 모든 오류 해결해줌
## 김세훈
* 메인화면 뷰 개발
* 메인화면 서버 통신
## 최정원
* 미션 레이아웃
* 미션 다이어로그 레이아웃 구현 ( 다이어로그에 들어가는 데이터값 전달 구현)
* 미션뷰 뒤로가기 버튼 기능 구현( 서버 통신 데이터값 전달)
* 미션뷰 팝업창 서버통신 및 확인버튼 구현 

### 모든 사람 각자 담당한 서버 통신 및 구현 완료 (서버 모든 api 통신함)
```kotlin
object ServiceCreator {
    private const val BASE_URL = "https://asia-northeast3-whatcolor-d1250.cloudfunctions.net/api/"
    private val gson = GsonBuilder().setLenient().create()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val apiService: WhatColorService = retrofit.create(WhatColorService::class.java)
}
```
서버통신 싱글톤패턴 구현

```kotlin
interface WhatColorService {
    @GET("user/{uuid}")
    fun getInfo(@Path("uuid") uuid: String): Call<ResponseExist>

    @POST("user")
    fun postUserInfo(@Body body: RequestUserInfo): Call<ResponseUserInfo>

    @GET("main/{id}")
    fun getMain(
        @Path("id") id : String
    ) : Call<ResponseColorData>

    @GET("mission/{uuid}")
    fun getMission(
        @Path("uuid") uuid: String): Call<ResponseMissionData>
}
```
서버 구현을 위한 interface
getInfo, postuserInfo - 강민
getMain - 세훈
getMission - 정원

# :white_check_mark: 코드 컨벤션
* xml id의 경우 textview면 `tv_`로 시작해주시면 되고, recyclerview면 `rv_` 이런식으로 시작하면 됩니다.
* 클래스명은 대문자, 변수명은 소문자로 시작합니다.
* 함수가 너무 커지면 외부로 빼주시면 좋습니다.

## **Android Naming Convention**

- 클래스명, 함수명, 변수명 등 모든 이름은 어떤 역할을 하는지 한눈에 알 수 있도록 하기
- id명은 겹치지 않게 하기 위해 어떤 액티비티(프래그먼트)에서 쓰고 있는지 명시
  <br>

### 1. Class file - UpperCamelCase 사용

- 클래스 파일 이름은 **UpperCamelCase(aka 파스칼 케이스(PascalCase))** 로 작성

- 전체 이름의 첫 문자를 포함한 각 단어의 첫 문자를 대문자로 표시한다.

  **ex) SignInActivity, SiginInFragment, ImageUploaderService, ChangePasswordDialog**

<br>

### 2. Resources file - snake_case

- 리소스 파일 이름은 **snake_case**로 작성
- 모든 단어는 소문자로, 각 단어의 사이를 **언더바 _** 로 구분해주는 표기법
- **ex) image_logo.png, ic_back.xml, menu_main.xml**
- **ex) image_logo.png, ic_back.xml, menu_main.xml**

<br>

### 3. Layout file - snake_case

- 레이아웃 파일 이름 또한 마찬가지로 **snake_case**로 작성
- [what]_ [where]
- **ex) activity_main.xml, fragment_login.xml, dialog_change_password.xml, item_**
- xml파일의 id명은 [what]_ [where]_ []  → home에서 쓰는 TextView라고 치면 text_home_user
- TextView : tv_ 
  <br> EditText : et_
  <br> ImageView : image_
  <br> Button : btn_
  <br> ConstraintLayout : layout_
  <br> Recyclerview : recycler_

<br>


# :white_check_mark: 브랜치 전략
## feat
* feat은 featue의 줄임말로 기능을 개발하는 브랜치입니다.
* 브랜치 이름 양식은 **feat/<이슈내용>**입니다.
* 메인화면 ui를 구현하는 작업이라면, `feat/main_ui` 이런식으로 브랜치를 생성할 수 있습니다.

## develop
* develop은 default 브랜치로 `feat` 브랜치에서 작업이 완료되었을 때 작업한 내용을 바탕으로 pull request를 보내는 브랜치입니다.
* 개발을 다 하시면, 개발이 되어 있는 `feat` 브랜치에서 `develop` 브랜치로 pull request를 보내시면 됩니다.
* `feat` 브랜치는 여러 개이지만, `develop` 브랜치는 하나입니다.

## main
* main 브랜치에서는 develop 브랜치에서 앱 개발이 완료되었을 때 main으로 pull request를 보냅니다.
* 1.0.0버전 이후 버전이 변경될 때 develop 브랜치에서 main으로 pull request를 보냅니다.
 




  




