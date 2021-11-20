# WhatColorAndroid 

### :star: 1차 과제

# :white_check_mark: 서비스 이름과 간단한 서비스 소개
## 서비스 이름
* 너 무슨 색이야?!
## 간단한 서비스 소개
* 색깔로 정해지는 N개의 팀! 미션을 통해 컬러 메이트를 찾아라!

# :white_check_mark: 각자 개발 담당 부분
## 이강민
* 스플래시 레이아웃 및 기능 구현
* 유저입력 레이아웃 및 기능 구현
* '팀 배정 완료' 레이아웃 및 기능 구현, 서버통신
* 팝업 기능 구현
* yb의 모든 오류 해결해줌
## 김세훈
* 메인리스트 뷰 개발
## 최정원
* 미션 레이아웃
* 미션 팝업창 레이아웃
* 미션뷰 뒤로가기 버튼 기능 구현
* 미션뷰 팝업창 서버통신 및 확인버튼 구현


# :white_check_mark: 코드 컨벤션
* xml id의 경우 textview면 `tv_`로 시작해주시면 되고, recyclerview면 `rv_` 이런식으로 시작하면 됩니다.
* 클래스명은 대문자, 변수명은 소문자로 시작합니다.
* 함수가 너무 커지면 외부로 빼주시면 좋습니다.


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


             



  




