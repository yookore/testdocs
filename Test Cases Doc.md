Test Cases

#Sign Up/Create Account#

**Input Test Data**<br/>
1.firstname: John<br/>
2.lastname: Baptist<br/>
3.email: john@yookos.com<br/>
4.country: Egypt<br/>
5.dob: 1979/05/17<br/>
6.cellphone: +278497<br/>
7.gender: Male<br/>
8.password: password

**Steps**<br/>
1. creates account

**Expected output**<br/> 1. firstname:  John<br/> 2. lastname:  Baptist<br/> 3. email: john@yookos.com<br/> 4. cellphone: +278497
———————————————————————————————————————————————————————

#User Exists#

**Input Test Data**<br/> 1. email: john@yookos.com

**Steps**<br/> 1. Checks if the user exists.

**Expected output**<br/> 1. email: john@yookos.com<br/> 2. firstname: John<br/> 3. lastname: Baptist
———————————————————————————————————————————————————————

#Get list of friends#

**Input Test Data**<br/> 1. username: johnbap<br/> 2. filter: all

**Steps**<br/> 1. Gets a list of friends.

**Expected output**<br/> 1. list: list of friends<br/> 2. username: johnbap<br/> 3. friendaccount:
———————————————————————————————————————————————————————

#Accept Friend#

**Input Test Data**<br/> 1. username: johnbap<br/> 2. targetUsername: ginald

**Steps**<br/> 1. Accepts a friend.<br/>

**Expected output**<br/> 1. username: johnbap<br/> 3. status: accepted
———————————————————————————————————————————————————————
#Reject Friend#

**Input Test Data**<br/> 1. username: johnbap<br/> 2. targetUsername: ginald

**Steps**<br/> 1. Accepts a friend.

**Expected output**<br/> 1. username: johnbap<br/> 3. status: rejected
———————————————————————————————————————————————————————

#Native Login#

**Input Test Data**<br/>  1. email: john@yookos.com<br/>  2. password: password<br/>

**Steps**<br/> 1. Native Login

**Expected output**<br/> 1. firstname:  John<br/> 2. lastname:  Baptist<br/> 3. email: john@yookos.com<br/> 4. cellphone: +278497<br/> 5. username: johnbap<br/> 6. profileimageurl: https://profileimageurl<br/>
———————————————————————————————————————————————————————

#Post Blog#

**Input Test Data**<br/>  1. username: johnbap<br/>  2. title: Apostle<br/>  3. text: This is a blog post text<br/>  4. tags: #myblog<br/>  5. mention: @ginald<br/>  6. photo: photoUrl<br/>  7. videos: videoUrl<br/>  8. audio: audioUrl

**Steps**<br/> 1. Posts a blog

**Expected output**<br/>  1. username: johnbap<br/>  2. title: Apostle<br/>  3. text: This is a blog post text<br/>  4. tags: #myblog<br/>  5. mention: @ginald<br/>  6. photo: photoUrl<br/>  7. videos: videoUrl<br/>  8. audio: audioUrl<br/>
———————————————————————————————————————————————————————

#Get Blog#

**Input Test Data**<br/>  1. postid: postid

**Steps**<br/> 1. Gets blog

**Expected output**<br/>  1. blogpostid: posted<br/>  2. text: Blog text here<br/>  3. actor: firstname: John lastname: Baptist profilepicthure: imgurl<br/>  4. creation date: 17/05/2015<br/>  5. modificationdate: 17/05/2015<br/>  6. comments: link: https://commentlink, action:remove, firstname:John, lastname:Baptist,  <br/>profilepic:imgUrl, creationdate:17/05/2015, username:johnbap<br/>
 7. like: link: https://likelink, action:unlike, firstname:John, lastname:Baptist <br/>  8. commentcount: 23<br/>  9. likecount: 44<br/> 10. viewcount: 56<br/> 11. mentions: profilelink:https://profile/johnbap, firstname:John, lastname:Baptist<br/> 12. tag: #john<br/> 13. attachment: attachUrl<br/>
———————————————————————————————————————————————————————

#Post Audio#

**Input Test Data**<br/>  1. username: johnap<br/>  2. caption: Photo caption<br/>  3. audioData<br/>

**Steps**<br/> 1. Posts Audio

**Expected output**<br/>  1. caption: Photo caption
———————————————————————————————————————————————————————

#Get Audio Post#

**Input Test Data**<br/>  1. audioId: audioId

**Steps**<br/> 1. Gets audio post

**Expected output**<br/>  1. audio: posted<br/>  2. text: audio text here<br/>  3. title: audio title here<br/>  4. actor: firstname: John, lastname: Baptist, profilepicthure: imgurl<br/>  5. creation date: 17/05/2015<br/>  6. modificationdate: 17/05/2015<br/>  7. comments: link: https://commentlink, action:remove, firstname:John, lastname:Baptist, profilepic:imgUrl, creationdate:17/05/2015, username:johnbap<br/>
 8. like: link: https://likelink, action:unlike, firstname:John, lastname:Baptist <br/>  9. commentcount: 23<br/>  10. likecount: 44<br/>  11. viewcount: 56<br/>  12. mentions: profilelink:https://profile/johnbap, first-name:John, lastname:Baptist<br/>  13. tag: #john<br/> 
———————————————————————————————————————————————————————

#Post Status#

**Input Test Data**<br/>  1. username: johnbap<br/>  2. text: This is a status Update Text<br/>  3. mention: @ginald<br/>  4. photo: photoUrl<br/>  5. videos: videoUrl<br/>  6. location: Randburg<br/>

**Steps**<br/> 1. Posts a status message

**Expected output**<br/>  1. username: johnbap<br/>  2. text: This is a blog post text<br/>
———————————————————————————————————————————————————————

#Get Status Update#

**Input Test Data**<br/>  1. statusupdateid: statusId

**Steps**<br/> 1. Gets Status Message

**Expected output**<br/>  1. statusupdateid: statusId<br/>  2. text: audio text here<br/>  3. actor: firstname: John, lastname: Baptist, profilepicthure: imgurl<br/>  4. creation date: 17/05/2015<br/>  5. modificationdate: 17/05/2015<br/>  6. comments: link: https://commentlink, action:remove, firstname:John, lastname:Baptist, 		profilepic:imgUrl, creationdate:17/05/2015, username:johnbap<br/>
 7. like: link: https://likelink, action:unlike, firstname:John, lastname:Baptist <br/>  8. commentcount: 23<br/>  9. likecount: 44<br/>  10. viewcount: 56<br/>  11. mentions: profilelink:https://profile/johnbap, firstname:John, lastname:Baptist<br/>  12. tag: #john<br/>  13. attachment: attachUrl<br/>
———————————————————————————————————————————————————————

#Update Profile Native#

**Input Test Data**<br/>  1. currentCity: Egypt City<br/>  2. homeCountry: Egypt<br/>  3. homeTown: Galilee<br/>  4. relationshipStatus: Single<br/>  5. interests: Jesus<br/>

**Steps**<br/> 1. Updates Profile Native

**Expected output**<br/>  1. userid: 23<br/>  2. sessionid: 321<br/> ———————————————————————————————————————————————————————

#Update Profile Responsive Web#

**Input Test Data**<br/>  1. email: john@yookos.com<br/>  2. dob: 1950/05/17<br/>  3. relationshipstatus: single<br/>  4. currentcountry: Egypt<br/>  5. biography: Jesus’s deciple<br/>  6. cellphone: +278497<br/>  7. firstname: John<br/>  8. lastname: Baptist<br/>  9. gender: Male<br/>  10. alternativeemail: john@gmail.com<br/>  11. homecountry: Egypt<br/>  12. timezone: Africa<br/>  13. imageurl: https://imageurl<br/>  14. title: Apostle<br/>  15. lastupdated: 17/05/2015<br/>  16. hometown: Galilee<br/>  17. currentcity: Egypt City<br/>  18. username: johnbap<br/>  19. interests: Jesus<br/>

**Steps**<br/> 1. Updates Profile Responsive Web

**Expected output**<br/>  1. userid: 23<br/>  2. sessionid: 321
———————————————————————————————————————————————————————

#Post profile picture#

**Input Test Data**<br/>  1. imageUrl: imgUrl<br/>  2. username: johnbap

**Steps**<br/> 1. Gets the profile pic image

**Expected output**<br/>  1. userid: 23<br/>  2. sessionid: 321
———————————————————————————————————————————————————————

#Gets profile#

**Input Test Data**<br/>  1. username: johnbap

**Steps**<br/> 1. Gets Profile data

**Expected output**<br/>  1. email: john@yookos.com<br/>  2. dob: 1950/05/17<br/>  3. relationshipstatus: single<br/>  4. currentcountry: Egypt<br/>  5. biography: Jesus’s deciple<br/>  6. cellphone: +278497<br/>  7. firstname: John<br/>  8. lastname: Baptist<br/>  9. gender: Male<br/>  10. alternativeemail: john@gmail.com<br/>  11. homecountry: Egypt<br/>  12. timezone: Africa<br/>  13. imageurl: https://imageurl<br/>  14. title: Apostle<br/>  15. lastupdated: 17/05/2015<br/>  16. hometown: Galilee<br/>  17. currentcity: Egypt City<br/>  18. username: johnbap<br/>  19. interests: Jesus
———————————————————————————————————————————————————————

#Sign Up/Create Account Social#

**Input Test Data**<br/>  1. firstname:  John<br/>  2. lastname:  Baptist<br/>  3. email: john@yookos.com<br/>  4. country: Egypt<br/>  5. dob: 1979/05/17<br/>  6. cellphone: +278497<br/>  7. gender: Male<br/>  8. password: password<br/>  9. verified: false<br/>  10. locale: GMT+2<br/>  11. timezone: 2<br/>  12. updated: 17/05/2015<br/>  13. fullnames: John Baptist<br/>

**Steps**<br/> 1. creates account Social

**Expected output**<br/> 1. firstname:  John<br/> 2. lastname:  Baptist<br/> 3. email: john@yookos.com<br/> 4. cellphone: +278497
———————————————————————————————————————————————————————

#Social Login#

**Input Test Data**<br/>  1. socialProviderEmail: john@yookos.com<br/>  2. password: password

**Steps**<br/> 1. Social Login

**Expected output**<br/> 1. firstname:  John<br/> 2. lastname:  Baptist<br/> 3. email: john@yookos.com<br/> 4. cellphone: +278497<br/> 5. username: johnbap<br/> 6. profileimageurl: https://profileimageurl<br/>
———————————————————————————————————————————————————————

#Sms verify User#

**Input Test Data**<br/>  1. verificationCode: verif123

**Steps**<br/> 1. Sms verify user

**Expected output**<br/> 1. firstname:  John<br/> 2. lastname:  Baptist<br/> 3. email: john@yookos.com<br/> 4. cellphone: +278497<br/> 5. username: johnbap<br/> 6. country: Egypt<br/> 7. verified: true<br/>
———————————————————————————————————————————————————————

#Email verify User#

**Input Test Data**<br/>  1. verificationCode: verif123

**Steps**<br/> 1. Email verify user

**Expected output**<br/> 1. firstname:  John<br/> 2. lastname:  Baptist<br/> 3. email: john@yookos.com<br/> 4. cellphone: +278497<br/> 5. username: johnbap<br/> 6. country: Egypt<br/> 7. verified: true
———————————————————————————————————————————————————————

#Email verify access Token#

**Input Test Data**<br/>  1. userId: johnbap<br/>  2. password: password

**Steps**<br/> 1. Email verify with access Token

**Expected output**<br/> 1. firstname:  John<br/> 2. lastname:  Baptist<br/> 3. access_token: 123<br/> 4. clients: 213<br/> 5. refresh_token: 312
———————————————————————————————————————————————————————

#Email phone verify User#

**Input Test Data**<br/>  1. email: john@yookos.com<br/>  2. +278497

**Steps**<br/> 1. Email phone verify user

**Expected output**<br/> 1. firstname:  John<br/> 2. lastname:  Baptist<br/> 3. email: john@yookos.com<br/> 4. cellphone: +278497<br/> 5. username: johnbap<br/> 6. country: Egypt<br/> 7. verified: true<br/>