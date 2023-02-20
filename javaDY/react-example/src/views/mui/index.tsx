import { Box, Button, createTheme, IconButton, ThemeProvider, TextField, Grid } from '@mui/material'
import { IconButtonProps } from '@mui/material';
import { styled } from '@mui/material';

import React, { useState } from 'react'
import DeleteIcon from '@mui/icons-material/Delete';
import SearchIcon from '@mui/icons-material/Search';
import AccessAlarmIcon from '@mui/icons-material/AccessAlarm';


//# MUI
//? Marterial User Interface
//? 구글의 머터리얼 디자인을 구현하는 오픈 소스 '리액트 컴포넌트' 라이브러리
//? 인스톨 즉시 배포 환경에서 사용할 수 있는 사전 구축된 컴포넌트의 모음
//? 디자인적으로 아름답고 다양한 사용자 정의 옵션을 제공

//? npm install @mui/material @emotion/react @emotion/styled

//# Mui styled method
//? mui component들의 style을 지정해주는 메서드

const CustomIconButton = styled(IconButton)<IconButtonProps>(({ theme }) => ({
    color: theme.palette.primary.dark
}));

//# Mui createTheme method
//? 새로운 mui theme를 생성하는 메소드
const theme = createTheme({
        palette: {
            primary: {
                main: '#FFFF00'
            },
            secondary:{
                main: '#00ff00'
            }
        }
});
const CustomIconButton2 = styled(IconButton)<IconButtonProps>(({ theme }) => ({
    color: theme.palette.secondary.main
}));

export default function Mui() {

    const [buttonDisabled, setButtonDisabled] = useState<boolean>(true);

  return (
    <>
        {/* 
        //# Button Component
        //? import { Button } from '@mui/material'
        //? import Button from '@mui/material'
        //^ Props
        //^ 1. variant: 버튼의 형태 ('text', 'contained', 'outlined')
        //? text: 문자로만 표기한 버튼
        //? contained: 배경색이 지정된 버튼 
        //? outlined: 테두리만 지정된 버튼
        */}
        <Button variant='text'>Text Button</Button>
        <Button variant='contained'>contained Button</Button>
        <Button variant='outlined'>outlined Button</Button>
        {/* 
        //? Mui의 Button component는 기본적으로 inline방식
        //^ 2. fullwidth
        //? Button Component를 block 형태로 지정 (가로 사이즈 100%)
        */}
        <Button fullWidth>full width Button</Button>
        {/* 
        //# 3. disable
        //? 버튼을 사용하지 못하도록 막아주는 Props
        */}
        <Button variant='contained' disabled={true}>disable true button</Button>
        <Button variant='contained' disabled={false}>disable false button</Button>
        
        <Button variant='contained' disabled={buttonDisabled}>disabled button</Button>
        <Button onClick={() => setButtonDisabled(!buttonDisabled)}>Click me</Button>
        {/* 
        //# 4. size
        //? Button size를 지정되어있는 사이즈로 지정할 때 
        //? small, medium, large
        */}
        <Button variant='contained' size='small'>Small Button</Button>
        <Button variant='contained' size='medium'>medium Button</Button>
        <Button variant='contained' size='large'>large Button</Button>
        {/* 
        //^ Icon (startIcon, endIcon)
        //? Button 내부에서 시작 혹은 종료 지점에 Icon을 추가하고 싶을 때 지정
        //? 값 : Icon Component
        //! npm install @mui/icons-material 을 추가해야 MUI Icon을 쓸 수 있음
        */}
        <Button variant='outlined' startIcon={(<DeleteIcon/>)}>Delete</Button>
        <Button variant='contained' endIcon={(<SearchIcon/>)}>Search</Button>
        {/* 
        //# IconButton
        //? Button을 Icon으로만 구성하고자 할 때 사용하는 컴포넌트
        //? Button Component의 모든 기능을 사용 가능
        //? 자식 컴포넌트에 Icon Component가 와야함
        //? import { IconButton } from '@mui/material';
        //? import IconButton from '@mui/material';
        */}
        <IconButton>
            <AccessAlarmIcon />
        </IconButton>
        {/* 
        //# Color
        //? default, primary, second...
        */}
        <IconButton color='primary'>
            <AccessAlarmIcon />
        </IconButton>

        <IconButton color='error'>
            <AccessAlarmIcon />
        </IconButton>

        {/* 
        //^ color Customization
    */}

        <CustomIconButton>
            <AccessAlarmIcon />
        </CustomIconButton>

        <CustomIconButton2>
            <AccessAlarmIcon />
        </CustomIconButton2>
        {/* 
        //# ThemeProvider Component
        //? createTheme 메서드로 생성한 커스텀 테마를
        //? 해당 컴포넌트 자손들에게 모두 적용되도록 하는 컴포넌트
        */}
        <ThemeProvider theme = {theme}>
            <IconButton color='primary'>
                <AccessAlarmIcon />
            </IconButton>
        </ThemeProvider>
        <br/>

        {/* 
        //# TextField Component
        //? HTML의 input 태그를 응용해서 조금 더 수월하게 사용할 수 있도록한 컴포넌트
        //? import { TextField } from '@mui/material';
        //? import TextField from '@mui/material/TextField';

        //^ Props
        //^ 1. variant
        //? 값: 'outlined', 'filled', 'standard'
        */}

        <TextField variant='outlined' />
        <TextField variant='filled' />
        <TextField variant='standard' />

        {/* 
        //^ 2. label
        //? 해당 TextFilled의 제목을 나타냄
        //? 해당 TextFilled의 Placeholder 역할
        */}
        <TextField label='Email' variant='outlined' />

        {/* 
        //^ 3. defaultValue
        //? 기본 값 지정
        //^ 4. required (true / false)
        //? 해당 Component에 필수로 값을 입력해야함
        //^ 5. disabled
        //? 해당 Component를 사용 불가능으로 만듦
        //^ 6. helperText
        //? 해당 Component 아래에 설명을 추가함
        */}
        <TextField variant='outlined' label='required' required={true}/>
        <TextField variant='outlined' label='defaultValue' defaultValue='default'/>
        <TextField variant='outlined' label='disabled' disabled={true}/>
        <TextField variant='outlined' label='helperText' helperText='This is HelperText'/>

        {/* 
        //# Box Component
        //? HTML의 Div 태그와 일맥상통
        //? import { Box } from '@mui/material';
        //? import Box from '@mui/material/Box';

        //^ Props
        //^ 1. components
        //? Box Component의 속성을 변경 - 모든 html 태그로 변경 가능\

        */}
        <Box component='h3'>Hello MUI</Box>
        <Box component='a' href='https://naver.com'>NAVER</Box>

        {/* 
        //# Grid Component 
        //? 공간은 12등분하여 자식 item을 구분
        //? 반응형 웹 구현에 기준
        //? import { grid } from '@mui/material'
        //? import grid from '@mui/material/grid'
        //^ Props
        //^ 1. container
        //? 해당 Component의 공산을 12등분으로 나눔
        //^ 2. item
        //? 12등분으로 나눠진 공간에 배치될 요소 
        //^ 3. spacing
        //? item간의 간격 지정 - container로 지정된 Grid Component에서 사용
        //^ 4. xs, sm, md, lg, xl
        //? xs - 576px < width
        //? sm - 576px <= width
        //? md - 768px <= width
        //? lg - 992px <= width
        //? xl - 1200px <= width
        */}

        <Grid container spacing={1}>
            <Grid item xs = {12} md={6} xl={4}>
                <Box sx={{height: '100px', backgroundColor: 'red'}}></Box>
            </Grid>

            <Grid item xs = {12} md={6} xl={4}>
                <Box sx={{height: '100px', backgroundColor: 'blue'}}></Box>
            </Grid>

            <Grid item xs = {12} md={12} xl={4}>
                <Box sx={{height: '100px', backgroundColor: 'red'}}></Box>
            </Grid>
        </Grid>
    </>
  )
}
