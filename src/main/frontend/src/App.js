import React, {useState, useEffect, useCallback} from "react";
import "./App.css";
import axios from "axios";
import {useDropzone} from 'react-dropzone';

const UserProfiles = () => {
  const  [UserProfiles, setUserProfiles] = useState([]);
  const fetchUserProfiles = () => {
    axios.get("http://localhost:8080/api/v1/user-profile").then(res => {
      console.log(res);
      setUserProfiles(res.data);
    });
  }

  useEffect( () => {
    fetchUserProfiles();
  }, []);

  return UserProfiles.map((userProfile, index) => {
    return (
      <div key={index}>
        {userProfile.userProfileId ? 
          <img src={`http://localhost:8080/api/v1/user-profile/${userProfile.userProfileId}/image/download`} alt="uploaded file" /> 
          : null}
        <br />
        <br />
        <h1>Username: {userProfile.userName}</h1>
        <p>ID: {userProfile.userProfileId}</p>
        <DropZone {...userProfile}/>
        <br />
      </div>
    )
  })
}

function DropZone({userProfileId}) {
  const onDrop = useCallback(acceptedFiles => {
    const file = acceptedFiles[0];

    console.log(file);

    const formData = new FormData();
    formData.append("file", file);

    axios.post(
      `http://localhost:8080/api/v1/user-profile/${userProfileId}/image/upload`,
      formData,
        {
          headers: {
            "Content-Type": "multipart/form-data"
          }
        }
      ).then( () => {
        console.log("file uploaded succesfully");
      }).catch( err => {
        console.log(err);
      });
  }, [])
  const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})

  return (
    <div {...getRootProps()}>
      <input {...getInputProps()} />
      {
        isDragActive ?
          <p>Drop the files here ...</p> :
          <button><p>Drag 'n' drop</p></button>
      }
    </div>
  )
}

function App() {
  return (
    <div className="App">
      <UserProfiles />
    </div>
  );
}

export default App;
