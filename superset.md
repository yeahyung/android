# Superset

Superset은 Apache재단의 오픈소스 데이터 시각화 툴이다.



## 환경 관련 및 설치

Python 3.6 기반으로, python 2.* 버전으로는 동작 안하고 3.6 대 버전 에서 정상적으로 작동하며 3.7대 버전에서의 작동도 지원한다. 3.6대 버전의 python 가상환경을 구성하는 것을 권장하고 있다. 따라서 conda나 python virtualenv 를 이용하여 가상환경 구성을 할 수 있다.

pip 기반으로 설치할 수 있으며 flask 기반으로 동작한다.

각종 DB와의 연결을 위해 SQLAlchemy 라이브러리를 활용하며 해당 라이브러리가 지원하는 모든 DB와 연결이 가능하다. DB와 관련된 드라이버를 pip로 설치해야한다.



## 기능

#### Caching

Flask-Cache를 이용해 캐시를 사용하며, [차트로딩](https://github.com/apache/incubator-superset/issues/7340) 등의 성능에 개선을 이루고 있다.

#### Domain Sharding 

브라우저 별로 각 도메인에 대해 가능한 연결 갯수가 정해져 있다(Chrome 의 경우 6개가 제한). 여러 개의 domain으로 나누어진 리소스를 다운받도록 해 dashboard같이 많은 리소스를 요구하는 객체들도 한번에 더 많이 받을 수 있는 장점이 있다.

#### Celery Task

거대한 양의 데이터를 다룰때는 query의 수행시간이 길어질 수 있다. web request 에서는 timeout(30~60s) 존재하는데 , Superset에는 celery worker라는 모듈으로 백엔드에서 비동기 request를 해서 긴 시간이 걸리는 query도 수행할 수 있다.

#### SQL Lab

연결할 수 있는 모든 종류의 Database에 SQL query문을 작성하여 결과를 받을 수 있으며, 수행한 쿼리는 로그로 남아 검색할 수 있으며 유용한 쿼리를 저장하는 기능도 있다. Celery Task의 지원으로 오랜시간이 걸리는 Query 등 도 수행 가능하다.



## 단점

Database를 제외한 data source의 경우 상대적으로 지원이 미흡하다. csv 형식만 지원하며 업로드할때 연결된 database에 올리는 방식으로 작동한다.



## Use Cases

superset은 Data Ingestion 능력이 뛰어난 Druid와 함께 많이 사용되고 Native하게 지원한다. Druid의 경우 실시간 데이터를 받아오는데 유리하도록 설계 되었으며 Kafka도 Native하게 지원한다. 또 schedule refresh, force refresh 등 dashboard를 refresh 할 수 있어 실시간 모니터링 솔루션에 잘 활용된다.

현재 [Airbnb](https://pt.slideshare.net/BillLiu31/apache-superset) 에서는 발생하는 Event logs 를 kafka를 통해 druid로 보내고, 이를 Superset을 사용함으로써 분석에 사용하고 있다.





## 비교

|             | Apache Superset                                              | Power bi                                                     | Metatron                                                     |
| ----------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| SQL 지원    | SQL Lab에서 연결된 DB와 interactive하게 query 확인 가능 하고 csv로 export도 가능 | SQL server와 연결 할 수 있지만 query 문 사용은 할 수 없음    | 워크벤치에서 SQL로 데이터                                    |
| 시각화      | 막대, 선, 테이블, 맵 등 여러가지 차트 및 마크업, IFrame, Big number 여러가지 Dashboard에 도움될만한 | 막대, 선, 테이블, 맵 등 여러가지 차트뿐 아니라 R/Python 스크립트의 시각화, 마켓플레이스에서 추가 다운로드 까지 가능 |                                                              |
| 비용        | 무료                                                         | 무료, pro, premium 존재                                      | Discovery는 무료                                             |
| 파일 Import | csv, tsv 형식만 지원 <br />해당 파일도 database를 통해 업로드 해야함 | json, excel, csv, tsv, xml, pdf, text 등 여러 파일을 지원함  | csv, excel 파일을 지원함                                     |
| refresh     | scheduled refresh, force refresh 둘다 지원                   | Direct Query 사용시 scheduled refresh, force refresh 둘다 지원 | refresh 관련 정책 없음                                       |
| 지원 DB     | [지원DB모음](https://superset.incubator.apache.org/installation.html#database-dependencies) 오픈소스나 빅데이터 처리에 유용한 여러 DB를 지원한다. | [지원DB모음](https://docs.microsoft.com/en-us/power-bi/power-bi-data-sources) 주로 Enterprise DB가 많다. | MYSQL, PostgreSQL, HIve, Presto, Druid, MSSQL<br /> Druid Native하게 지원 |

